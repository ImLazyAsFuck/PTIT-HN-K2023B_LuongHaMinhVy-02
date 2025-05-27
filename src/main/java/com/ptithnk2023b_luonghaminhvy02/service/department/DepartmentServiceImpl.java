package com.ptithnk2023b_luonghaminhvy02.service.department;

import com.ptithnk2023b_luonghaminhvy02.model.Department;
import com.ptithnk2023b_luonghaminhvy02.repository.department.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAllDepartment(){
        return departmentRepository.findAllDepartment();
    }

    @Override
    public List<Department> findPageDepartment(int page){
        return departmentRepository.findPageDepartment(page);
    }

    @Override
    public List<Department> searchDepartment(String keyword){
        return departmentRepository.searchDepartment(keyword);
    }

    @Override
    public Department findDepartmentById(int departmentId){
        return departmentRepository.findDepartmentById(departmentId);
    }

    @Override
    public boolean addDepartment(Department department){
        return departmentRepository.addDepartment(department);
    }

    @Override
    public boolean updateDepartment(Department department){
        return departmentRepository.updateDepartment(department);
    }

    @Override
    public boolean deleteDepartment(int departmentId){
        return departmentRepository.deleteDepartment(departmentId);
    }

    @Override
    public int getTotalPage(){
        return departmentRepository.getTotalPage();
    }

    @Override
    public boolean uniqueName(String name){
        return departmentRepository.uniqueName(name);
    }
}
