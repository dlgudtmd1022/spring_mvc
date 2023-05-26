<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>${title}</h1>
<%--폼 데이터 경로는 애매하면 전체경로를 다 적습니다.--%>
<form action="http://localhost:8080/chap03/foodorder" method="POST">
    주문자명 : <input type="text" name = "name"> <br>
    주문번호 : <input type="text" name = "num"> <br>
    주문음식 : <input type="text" name = "food"> <br>
    <input type="submit" value="주문하기">
</form>
</body>
</html>