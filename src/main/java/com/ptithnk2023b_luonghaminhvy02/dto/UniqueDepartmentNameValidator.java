package com.ptithnk2023b_luonghaminhvy02.dto;

import com.ptithnk2023b_luonghaminhvy02.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueDepartmentNameValidator implements ConstraintValidator<UniqueDepartmentName, String>{
    @Autowired
    private DepartmentService departmentService;

    @Override
    public void initialize(UniqueDepartmentName constraintAnnotation){
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext){
        if(s == null || s.isEmpty()) return true;
        return !departmentService.uniqueName(s);
    }
}
