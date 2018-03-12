<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<li><img src = ${user.headurl} /></li>
		<li>用户账号 : ${user.user_name}</li>
		<li>用户手机号 ：${user.phone } </li>
		<li>用户真实姓名：${user.real_name }</li>
		<li>用户现金资产:${ user.cash_asset}</li>
		<li>用户获得资产:${ user.score_asset}</li>
		<li>用户盈利资产:${ user.coin_asset}</li>
	</div>
</body>
</html>