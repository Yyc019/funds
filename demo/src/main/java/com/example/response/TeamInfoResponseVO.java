package com.example.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class TeamInfoResponseVO {

    @ApiModelProperty(value = "測試流水號", example = "demo-1")
    private String id;

    @NonNull
    @ApiModelProperty(value = "小組名稱", example = "安卓系統組")
    private String name;

    @NonNull
    @ApiModelProperty(value = "內容說明", example = "開發Android")
    private String remark;

    @NonNull
    @ApiModelProperty(value = "小組人數", example = "10")
    private Integer employees;
}
