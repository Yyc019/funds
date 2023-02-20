package com.example.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateTeamInfoResponseVO {
    private List<TeamInfoResponseVO> createdTeamInfoList;
    private int execResult;
}
