package com.ptithnk2023b_luonghaminhvy02.repository.department;

import com.ptithnk2023b_luonghaminhvy02.model.Department;
import com.ptithnk2023b_luonghaminhvy02.utils.DBConnect;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository{
    @Override
    public List<Department> findAllDepartment(){
        Connection con = null;
        CallableStatement cs = null;
        List<Department> departments = new ArrayList<>();
        try{
            con = DBConnect.getConnection();
            cs = con.prepareCall("{call find_all_department()}");
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Department department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setDescription(rs.getString("description"));
                department.setStatus(rs.getBoolean("status"));
                departments.add(department);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBConnect.closeConnection(con, cs);
        }
        return departments;
    }

    @Override
    public List<Department> findPageDepartment(int page){
        Connection con = null;
        CallableStatement cs = null;
        List<Department> departments = new ArrayList<>();
        try{
            con = DBConnect.getConnection();
            cs = con.prepareCall("{call find_department_by_page(?)}");
            cs.setInt(1, page);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Department department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setDescription(rs.getString("description"));
                department.setStatus(rs.getBoolean("status"));
                departments.add(department);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBConnect.closeConnection(con, cs);
        }
        return departments;
    }

    @Override
    public List<Department> searchDepartment(String keyword){
        Connection con = null;
        CallableStatement cs = null;
        List<Department> departments = new ArrayList<>();
        try{
            con = DBConnect.getConnection();
            cs = con.prepareCall("{call find_department_by_name(?)}");
            cs.setString(1, keyword);
            ResultSet rs = cs.executeQuery();
            while(rs.next()){
                Department department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setDescription(rs.getString("description"));
                department.setStatus(rs.getBoolean("status"));
                departments.add(department);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBConnect.closeConnection(con, cs);
        }
        return departments;
    }

    @Override
    public Department findDepartmentById(int departmentId){
        Connection con = null;
        CallableStatement cs = null;
        Department department = null;
        try{
            con = DBConnect.getConnection();
            cs = con.prepareCall("{call find_department_by_id(?)}");
            cs.setInt(1, departmentId);
            ResultSet rs = cs.executeQuery();
            if(rs.next()){
                department = new Department();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setDescription(rs.getString("description"));
                department.setStatus(rs.getBoolean("status"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBConnect.closeConnection(con, cs);
        }
        return department;
    }

    @Override
    public boolean addDepartment(Department department){
        Connection con = null;
        CallableStatement cs = null;
        try{
            con = DBConnect.getConnection();
            cs = con.prepareCall("{call add_department(?, ?)}");
            cs.setString(1, department.getDepartmentName());
            cs.setString(2, department.getDescription());
            return cs.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            DBConnect.closeConnection(con, cs);
        }
        return false;
    }

    @Override
    public boolean updateDepartment(Department department){
        Connection con = null;
        CallableStatement cs = null;
        try{
            con = DBConnect.getConnection();
            cs = con.prepareCall("{call update_department(?, ?, ?, ?)}");
            cs.setInt(1, department.getDepartmentId());
            cs.setString(2, department.getDepartmentName());
            cs.setString(3, department.getDescription());
            cs.setBoolean(4, department.isStatus());
            return cs.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            DBConnect.closeConnection(con, cs);
        }
        return false;
    }

    @Override
    public boolean deleteDepartment(int departmentId){
        Connection con = null;
        CallableStatement cs = null;
        try{
            con = DBConnect.getConnection();
            cs = con.prepareCall("{call delete_department(?)}");
            cs.setInt(1, departmentId);
            return cs.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            DBConnect.closeConnection(con, cs);
        }
        return false;
    }

    @Override
    public int getTotalPage(){
        Connection con = null;
        CallableStatement cs = null;
        int totalPage = 0;
        try{
            con = DBConnect.getConnection();
            cs = con.prepareCall("{call get_d_total_page(?)}");
            cs.registerOutParameter(1, java.sql.Types.INTEGER);
            cs.executeQuery();
            totalPage = cs.getInt(1);
            if(totalPage == 0) totalPage = 1;
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            DBConnect.closeConnection(con, cs);
        }
        return totalPage;
    }

    @Override
    public boolean uniqueName(String name){
        Connection con = null;
        CallableStatement cs = null;
        try{
            con = DBConnect.getConnection();
            cs = con.prepareCall("{call unique_name(?)}");
            cs.setString(1, name);
            cs.registerOutParameter(1, java.sql.Types.BOOLEAN);
            cs.executeQuery();
            return cs.getBoolean(1);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            DBConnect.closeConnection(con, cs);
        }
        return false;
    }
}
