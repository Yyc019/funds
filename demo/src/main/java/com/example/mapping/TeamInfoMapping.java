package com.example.mapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamInfoMapping {

    private String id;
    private String name;
    private String remark;
    private Integer employees;
    private LocalDateTime updateTime;
}
