<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/js/messages_zh.js"></script>
</head>
<body>
	<div>
		<c:if test="${user.user_id !=null}">		
           <div>
           		你好,你可以
               <a href="http://localhost/api/customer/user">查看我的信息</a>       
           </div>	        		   			
		</c:if>
		
		
		<c:if test="${user.user_id ==null}" >
				<div>					
					<a href="http://localhost/login" >请登陆</a>
				</div>
				<div>					
					<a href="http://localhost/regist" >没有账号，立即注册</a>
				</div>
		</c:if>
		
	</div>
</body>
</html>