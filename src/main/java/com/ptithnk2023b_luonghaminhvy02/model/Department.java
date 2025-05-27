package com.ptithnk2023b_luonghaminhvy02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department{
    private int departmentId;
    private String departmentName;
    private String description;
    private boolean status;
}
