package com.school_automation.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDTO {
    private Long id;
    private String name;
    private String job;
}
