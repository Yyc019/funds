package com.example.mapper;

import com.example.mapping.TeamInfoMapping;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TeamInfoMapper {

    @SelectProvider(type = TeamInfoProvider.class, method = "getTeamInfoList")
    List<TeamInfoMapping> getTeamInfoList();

    @InsertProvider(type = TeamInfoProvider.class, method = "createTeamInfoList")
    Integer insertTeamInfo(@Param("newTeamInfo") TeamInfoMapping newTeamInfo);

    @DeleteProvider(type = TeamInfoProvider.class, method = "deleteTeamInfoList")
    Integer deleteTeamInfo(@Param("idList") List<String> idList);

    @UpdateProvider(type = TeamInfoProvider.class, method = "updateTeamInfoList")
    Integer updateTeamInfo(@Param("teamInfo") TeamInfoMapping teamInfo);
}
