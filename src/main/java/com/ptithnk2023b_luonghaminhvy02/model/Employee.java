package com.ptithnk2023b_luonghaminhvy02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee{
    private int employeeId;
    private String fullNames;
    private String email;
    private String phoneNumber;
    private String avatarUrl;
    private int departmentId;
    private boolean status;
    private LocalDateTime createdAt;
}
