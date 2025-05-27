<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 27/05/2025
  Time: 4:19 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="../css/index.css">
</head>
<body>
<h1>Thêm phòng ban</h1>
<form:form action="add" acceptCharset="UTC-8" modelAttribute="department" method="post">
  <form:input placeholder="department name" path="departmentName"/>
  <form:errors path="departmentName" cssStyle="color: red"/>
  <form:textarea placeholder="description" path="description"/>
  <form:button type="submit">Add</form:button>
</form:form>
</body>
</html>
