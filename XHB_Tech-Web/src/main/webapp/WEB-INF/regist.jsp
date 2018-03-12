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
<script type="text/javascript" src="/js/myCode.js"></script>
<script>	
	$(function(){
		$("#checkForm").validate({
			rules:{
				username:{
					required:true,
					minlength:6
				},
				password:{
					required:true,
					minlength:6
				},
				repassword:{
					required:true,
					equalTo:"[name='password']"
				},
				phone:{
					required:true,
					phone:true
				}
			},
			messages:{
				username:{
					required:"用户名不能为空!",
					minlength:"用户名不得少于6位！"
				},
				password:{
					required:"密码不能为空!",
					minlength:"密码不得少于6位!"
				},
				repassword:{
					required:"确认密码不能为空!",
					equalTo:"两次输入密码不一致!"
				}
			}
		});
	});
</script>
</head>
<body>
	<div>
		<c:if test="${ result.code != null&&result.code !=200}">		
		        
		    code:${result.code},message:${result.msg}     
		        	        		   			
		</c:if>
	</div>
	<div>
		 <a href="http://localhost:8080/login">我有账号，立即登陆</a>  
	</div>
	<div>
		<form action="${requestContext.request.contextPath}/api/customer/user" id="checkForm" 
		enctype="multipart/form-data"  method ="post">
			用户名:     <input type="text" name="user_name"  onblur="checkUsername(this.value)"/>
			<span id="usernameMsg" ></span><br/>
			密码: 	  <input type="password" name="password"/><br />
			再次输入密码:<input type="password" name="repassword"/><br />
			手机号码:   <input type="text" name="phone" onblur="checkphone(this.value)"/>
			<span id="phoneMsg" ></span><br/>
			请上传头像:
             <input type="file" name="image"></br>
			验证码:
			<input  type="text" name="captcha">
			<img id="codeImg" alt="验证码" src="/user/code" onclick="changeImg()"/><br/>
			<input type="submit"  value="注册"/>
		</form>
		<script>
			
			//对输入的用户名进行重复检查
			function checkUsername(username){
				//定义一个标志
				//alert(username);
				var flag=true;
				//当键盘输入光标离开文本框
				$.ajax({
					"url":"${requestContext.request.contextPath}/api/customer/user/checkusername",
					"data":{"user_name":username},
					"type":"POST",
					"dataType":"json",
					"success":function(data){
						//返回异步查询信息
						var msg = data.msg;
						//alert(msg);	
						usernameMsg.innerHTML=msg;  
						//账号重复
						if(data.code !=200){																		
							flag = false;
						}
					}
				});
				return flag;
			}
			
			
			//对输入的用户名进行重复检查
			function checkphone(phone){
				//定义一个标志
				var flag=true;
				//当键盘输入光标离开文本框
				$.ajax({
					"url":"${requestContext.request.contextPath}/api/customer/user/checkphone",
					"data":{"phone":phone},
					"type":"POST",
					"dataType":"json",
					"success":function(data){
						//返回异步查询信息
						var msg="";
						msg = data.msg;
						//alert(msg);	
						phoneMsg.innerHTML=msg;  						
						//账号重复
						if(result.code !=200){
							flag = false;
						}
					}
				});
				return flag;
			}
		</script>
	</div>
</body>
</html>