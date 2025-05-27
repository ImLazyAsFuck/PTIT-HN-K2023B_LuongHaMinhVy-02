<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 27/05/2025
  Time: 5:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="${department.departmentId}" acceptCharset="UTC-8" modelAttribute="department" method="post">
  <form:input placeholder="department name" path="departmentName"/>
  <form:errors path="departmentName" cssStyle="color: red"/>
  <form:textarea placeholder="description" path="description"/>
  <form:select path="status" >
    <form:option value="true">Active</form:option>
    <form:option value="false">Inactive</form:option>
  </form:select>
  <form:button type="submit">Edit</form:button>
</form:form>
</body>
</html>
