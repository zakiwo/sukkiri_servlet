<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Health" %>    

<%
//スコープを取得
Health health = (Health) request.getAttribute("health");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ健康診断結果</title>
</head>
<body>
<h1>スッキリ健康診断の結果</h1>
<p>
	身長:<%= health.getHeight() %><br>
	体重:<%= health.getWeight() %><br>
	BMI:<%= health.getBmi() %><br>
	体型:<%= health.getBodyType() %>
</p>
<a href="/example/HealthCheck">戻る</a>
</body>
</html>