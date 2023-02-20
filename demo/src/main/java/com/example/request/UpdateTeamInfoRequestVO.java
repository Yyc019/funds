package com.example.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UpdateTeamInfoRequestVO {
    @ApiModelProperty(value = "流水號", example = "demo-1")
    private String id;

    @ApiModelProperty(value = "team的名稱", example = "網頁組")
    private String name;

    @ApiModelProperty(value = "team的說明", example = "開發web和Android")
    private String remark;

    @ApiModelProperty(value = "team的組成人數", example = "10")
    private Integer employees;
}
