<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-05-22
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h1>注册</h1>
<p style="color: red; font-weight: 900">${msg}</p>
<%--${pageContext.request.contextPath}/RegistServlet--%>
<form action="<c:url value='/RegistServlet'/>" method="post">
    用户名：<input type="text" name="username"/><br>
    密 码：<input type="password" name="password"/><br>
    <input type="submit" value="注册"/>
</form>
</body>
</html>
