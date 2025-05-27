package com.ptithnk2023b_luonghaminhvy02.controller;

import com.ptithnk2023b_luonghaminhvy02.dto.DepartmentDTO;
import com.ptithnk2023b_luonghaminhvy02.model.Department;
import com.ptithnk2023b_luonghaminhvy02.service.department.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/department")
public class DepartmentController{
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public String department(Model model, @RequestParam(defaultValue = "1") int page){
        if(page < 1) page = 1;
        if(page > departmentService.getTotalPage()) page = departmentService.getTotalPage();
        model.addAttribute("departments", departmentService.findPageDepartment(page));
        model.addAttribute("totalPage", departmentService.getTotalPage());
        return "department_manager";
    }

    @GetMapping("add")
    public String addDepartment(Model model){
        model.addAttribute("department", new DepartmentDTO());
        return "add_department";
    }

    @PostMapping("add")
    public String addDepartment(@Valid @ModelAttribute("department") DepartmentDTO departmentDTO, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add_department";
        }
        departmentDTO.setStatus(true);
        departmentService.addDepartment(new Department(departmentDTO.getDepartmentId(), departmentDTO.getDepartmentName(), departmentDTO.getDescription(), departmentDTO.isStatus()));
        return "redirect:/department";
    }

    @GetMapping("edit/{departmentId}")
    public String editDepartment(Model model, @PathVariable int departmentId){
        Department department = departmentService.findDepartmentById(departmentId);
        if(department == null) return "redirect:/department";
        model.addAttribute("department", new DepartmentDTO(department.getDepartmentId(), department.getDepartmentName(), department.getDescription(), department.isStatus()));
        return "edit_department";
    }

    @PostMapping("edit/{departmentId}")
    public String editDepartment(@Valid @ModelAttribute("department") DepartmentDTO departmentDTO, BindingResult bindingResult, @PathVariable int departmentId){
        if(bindingResult.hasErrors()){
            return "edit_department";
        }
        departmentDTO.setDepartmentId(departmentId);
        departmentService.updateDepartment(new Department(departmentDTO.getDepartmentId(), departmentDTO.getDepartmentName(), departmentDTO.getDescription(), departmentDTO.isStatus()));
        return "redirect:/department";
    }

    @GetMapping("delete/{departmentId}")
    public String deleteDepartment(@PathVariable int departmentId){
        departmentService.deleteDepartment(departmentId);
        return "redirect:/department";
    }
}
