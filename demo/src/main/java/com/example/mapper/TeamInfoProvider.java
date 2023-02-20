package com.example.mapper;


import com.example.mapping.TeamInfoMapping;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class TeamInfoProvider {

    public static String getTeamInfoList(){
        StringBuilder sb = new StringBuilder();

        sb.append("select * ");
        sb.append("from team_info ");

        return sb.toString();
    }

    public static String createTeamInfoList(TeamInfoMapping newTeamInfo){
        StringBuilder sb = new StringBuilder();

        sb.append("insert into team_info (id, name, remark, employees) ");
        sb.append("values (#{newTeamInfo.id}, #{newTeamInfo.name}, #{newTeamInfo.remark}, #{newTeamInfo.employees}) ");

        return sb.toString();
    }

    public static String deleteTeamInfoList(List<String> idList){
        StringBuilder sb = new StringBuilder();
        String ids = "'" + StringUtils.join(idList, "','") + "'";

        sb.append("delete from team_info ");
        sb.append("where id in ( ");
        sb.append(ids);
        sb.append(") ");

        return sb.toString();
    }

    public static String updateTeamInfoList(TeamInfoMapping teamInfo){
        StringBuilder sb = new StringBuilder();

        sb.append("update team_info ");
        sb.append("set name = #{teamInfo.name}, remark = #{teamInfo.remark}, employees = #{teamInfo.employees} ");
        sb.append("where id = #{teamInfo.id} ");

        return sb.toString();
    }
}