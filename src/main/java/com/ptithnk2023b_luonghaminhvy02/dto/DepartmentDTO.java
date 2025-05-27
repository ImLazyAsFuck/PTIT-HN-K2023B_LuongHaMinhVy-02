package com.ptithnk2023b_luonghaminhvy02.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO{
    private int departmentId;

    @UniqueDepartmentName
    @NotBlank(message = "Tên nhóm phòng không được để trống")
    private String departmentName;
    private String description;
    private boolean status;
}
