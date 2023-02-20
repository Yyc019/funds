package com.example.request;

import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
public class DeleteTeamInfoRequestVO {
    @NonNull
    @NotEmpty
    @ApiModelProperty(value = "要刪除的id列表", example = "demo-6")
    private List<String> idList;
}
