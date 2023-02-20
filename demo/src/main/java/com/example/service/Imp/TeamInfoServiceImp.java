package com.example.service.Imp;

import com.example.demo.response.UpdateTeamInfoResponseVO;
import com.example.mapper.TeamInfoMapper;
import com.example.mapping.TeamInfoMapping;
import com.example.request.CreateTeamInfoRequestVO;
import com.example.request.DeleteTeamInfoRequestVO;
import com.example.request.TeamInfoRequestVO;
import com.example.request.UpdateTeamInfoRequestVO;
import com.example.response.CreateTeamInfoResponseVO;
import com.example.response.DeleteTeamInfoResponseVO;
import com.example.response.GetTeamInfoResponseVO;
import com.example.response.TeamInfoResponseVO;
import com.example.service.TeamInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamInfoServiceImp implements TeamInfoService {

    @Autowired
    private TeamInfoMapper teamInfoMapper;

    @Override
    public GetTeamInfoResponseVO getTeamInfo() {
        List<TeamInfoMapping> getTeamInfoList = teamInfoMapper.getTeamInfoList();
        GetTeamInfoResponseVO responseVO = GetTeamInfoResponseVO.builder()
                .teamInfoList(createTeamInfoResponseVO(getTeamInfoList))
                .build();
        return responseVO;
    }

    @Override
    public CreateTeamInfoResponseVO createTeamInfo(CreateTeamInfoRequestVO requestVO) {
        List<TeamInfoMapping> newTeamInfoVOList = new ArrayList<>();
        int count = 0;

        //建構一個TeamInfoMapping 格式的參數temp,去跑getNewTeamInfoList，最後組成一個List
        for(TeamInfoRequestVO teamInfoRequestVO : requestVO.getNewTeamInfoList()){
            TeamInfoMapping temp = TeamInfoMapping.builder()
                    .id(teamInfoRequestVO.getId())
                    .name(teamInfoRequestVO.getName())
                    .remark(teamInfoRequestVO.getRemark())
                    .employees(teamInfoRequestVO.getEmployees())
                    .build();

            count += teamInfoMapper.insertTeamInfo(temp);
            newTeamInfoVOList.add(temp);
        }

        CreateTeamInfoResponseVO responseVO = CreateTeamInfoResponseVO.builder()
                .createdTeamInfoList(createTeamInfoResponseVO(newTeamInfoVOList))
                .execResult(count)
                .build();

        return responseVO;
    }

    @Override
    public DeleteTeamInfoResponseVO deleteTeamInfo(DeleteTeamInfoRequestVO requestVO) {
        DeleteTeamInfoResponseVO responseVO = DeleteTeamInfoResponseVO.builder()
                .exeResult(teamInfoMapper.deleteTeamInfo(requestVO.getIdList()))
                .build();

        return responseVO;
    }

    @Override
    public UpdateTeamInfoResponseVO updateTeamInfo(UpdateTeamInfoRequestVO requestVO) {
        TeamInfoMapping temp = TeamInfoMapping.builder()
                .id(requestVO.getId())
                .name(requestVO.getName())
                .remark(requestVO.getRemark())
                .employees(requestVO.getEmployees())
                .build();

        return UpdateTeamInfoResponseVO.builder().execResult(teamInfoMapper.updateTeamInfo(temp)).build();
    }

    private List<TeamInfoResponseVO> createTeamInfoResponseVO(List<TeamInfoMapping> teamInfoList) {
        List<TeamInfoResponseVO> responseTeamInfoList = new ArrayList<>();
        for (TeamInfoMapping ti : teamInfoList) {
            responseTeamInfoList.add(TeamInfoResponseVO.builder()
                    .id(ti.getId())
                    .name(ti.getName())
                    .remark(ti.getRemark())
                    .employees(ti.getEmployees())
                    .build());
        }
        return responseTeamInfoList;
    }
}