<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 27/05/2025
  Time: 2:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/index.css">
    <link rel="stylesheet" href="../css/departmentStyle.css">
</head>
<body>
    <h2>Quản lý phòng ban</h2>
    <a href="/department/add">Thêm mới</a>
    <a href="/">Quay lại menu</a>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Tên phòng ban</th>
                <th>Mô tả</th>
                <th>Trạng thái</th>
                <th>Chức năng</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${departments}" var="department">
                <tr>
                    <td>${department.departmentId}</td>
                    <td>${department.departmentName}</td>
                    <td>${department.description}</td>
                    <td>${department.status}</td>
                    <td>
                        <a href="/department/edit/${department.departmentId}">Sửa</a>
                        <p onclick="deleteDepartment(${department.departmentId})">Xóa</p>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
<script>
    function deleteDepartment(departmentId) {
        if(confirm("Bạn có chắc chắn muốn xóa phòng ban này?")) {
            window.location.href = "/department/delete/" + departmentId;
        }else{
            return false;
        }
    }
</script>
</html>
