package com.example.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetTeamInfoResponseVO {
    private List<TeamInfoResponseVO> teamInfoList;
}
