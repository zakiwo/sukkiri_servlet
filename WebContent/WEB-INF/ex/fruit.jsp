<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "ex.Fruit" %>
<%
	//スコープを取得
	Fruit fruit = (Fruit) application.getAttribute("fruit");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フルーツの値段</title>
</head>
<body>
<p><%= fruit.getName() %>の値段は<%= fruit.getPrice() %>円です</p>
</body>
</html>