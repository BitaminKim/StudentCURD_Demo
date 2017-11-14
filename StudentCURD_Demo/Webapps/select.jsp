<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" style="border-collapse:collapse">
<tr><td>姓名</td><td>性别</td><td>出生日期</td><td>手机</td><td>照片</td><td>兴趣爱好</td><td>地址</td><td>自我介绍</td><td>操作</td></tr>
<c:forEach items="${list}" var="user" >  
<tr id="${user.id}">
<td id="name">${user.name}</td>
<td id="sex">${user.sex}</td>
<td id="birthday">${user.birthday}</td>
<td width="150" id="phone">${user.phone}</td>
<td width="110" height="110" id="pic"><img src="http://localhost:8080/StudentCURD_Demo/upload/${user.pic}" height="100" width="100"/></td>
<td width="300" id="likesome">${user.likesome}</td>
<td width="200" id="address">${user.address}</td>
<td width="200" id="aboutme">${user.aboutme}</td>
<!-- <td><a href="update.jsp">修改</a> &nbsp <a href="DeleteStudent?id=${user.id}">删除</a></td> -->
<td><a href="UpdateForward?id=${user.id}" >修改</a> &nbsp <a href="DeleteStudent?id=${user.id}">删除</a></td>
</tr>
</c:forEach>  
</table>
<a href="index.jsp">返回继续添加</a>
</body>
</html>