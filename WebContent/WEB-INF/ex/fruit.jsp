<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//スコープを取得
	//Fruit fruit = (Fruit) application.getAttribute("fruit");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>フルーツの値段</title>
</head>
<body>
<!--  ELで書き換え-->
<p>${applicationScope.fruit.name }の値段は${applicationScope.fruit.price }円です</p>
</body>
</html>