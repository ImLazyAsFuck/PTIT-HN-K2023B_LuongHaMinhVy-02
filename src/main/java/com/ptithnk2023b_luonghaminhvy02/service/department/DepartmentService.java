package com.ptithnk2023b_luonghaminhvy02.service.department;

import com.ptithnk2023b_luonghaminhvy02.model.Department;

import java.util.List;

public interface DepartmentService{
    List<Department> findAllDepartment();
    List<Department> findPageDepartment(int page);
    List<Department> searchDepartment(String keyword);
    Department findDepartmentById(int departmentId);
    boolean addDepartment(Department department);
    boolean updateDepartment(Department department);
    boolean deleteDepartment(int departmentId);
    int getTotalPage();
    boolean uniqueName(String name);
}
