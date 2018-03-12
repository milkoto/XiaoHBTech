<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="/js/messages_zh.js"></script>
</head>
<!-- 验证码插件 -->
<script type="text/javascript" src="/js/myCode.js"></script>>

</script>
<body>
	<div>
		<c:if test="${ result.code != null&&result.code !=200}">		
		        
		    code:${result.code},message:${result.msg}     
		        	        		   			
		</c:if>
	</div>
	<div>
		 <a href="http://localhost/regist">没有账号，前去注册</a>  
	</div>
	<div>	
		<form id="loginform" action="${pageContext.request.contextPath }/api/customer/token" method="post">			
			用户名	
			<input type="text" name="user_name"  id="user_name" /><br/>
			密码
			<input type="password" name="password" size="34px" id="password"/>	<br/>		
			验证码：
            <input  type="text" name="captcha">
            <img id="codeImg" alt="验证码" src="/user/code" onclick="changeImg()"/><br/>	
            <input type ="submit"  value ="登陆 "	  />
			<table>
		</form>
	</div>
	
</body>
</html>