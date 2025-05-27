package com.ptithnk2023b_luonghaminhvy02.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnect{
    public static final String DB_URL = "jdbc:mysql://localhost:3306/quanlynhansu?useSSL=false&serverTimezone=UTC";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "a@1234";

    public static Connection getConnection(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = java.sql.DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        }catch(ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }
        return con;
    }

    public static void closeConnection(Connection con, CallableStatement cs){
        try{
            if(con != null) con.close();
            if(cs != null) cs.close();
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
