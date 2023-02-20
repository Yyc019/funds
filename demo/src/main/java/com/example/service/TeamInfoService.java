package com.example.service;

import com.example.demo.response.UpdateTeamInfoResponseVO;
import com.example.request.CreateTeamInfoRequestVO;
import com.example.request.DeleteTeamInfoRequestVO;
import com.example.request.UpdateTeamInfoRequestVO;
import com.example.response.CreateTeamInfoResponseVO;
import com.example.response.DeleteTeamInfoResponseVO;
import com.example.response.GetTeamInfoResponseVO;
import org.springframework.stereotype.Service;

@Service
public interface TeamInfoService {

    GetTeamInfoResponseVO getTeamInfo();

    CreateTeamInfoResponseVO createTeamInfo(CreateTeamInfoRequestVO requestVO);

    DeleteTeamInfoResponseVO deleteTeamInfo(DeleteTeamInfoRequestVO requestVO);

    UpdateTeamInfoResponseVO updateTeamInfo(UpdateTeamInfoRequestVO requestVO);
}
