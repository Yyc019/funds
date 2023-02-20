package com.example.request;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreateTeamInfoRequestVO {
    @NotNull
    @NotEmpty
    @Valid
    @ApiModelProperty()
    private List<TeamInfoRequestVO> newTeamInfoList;
}
