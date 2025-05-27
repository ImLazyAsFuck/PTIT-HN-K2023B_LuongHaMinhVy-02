package com.ptithnk2023b_luonghaminhvy02.dto;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueDepartmentNameValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueDepartmentName{
    String message() default "Tên nhóm phòng đã tồn tại";
    Class<?>[] groups() default {};
    Class<? extends javax.validation.Payload>[] payload() default {};
}
