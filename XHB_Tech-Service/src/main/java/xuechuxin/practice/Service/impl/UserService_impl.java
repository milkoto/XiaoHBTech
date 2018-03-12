package xuechuxin.practice.Service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.user.UserDestinationMessageHandler;
import org.springframework.stereotype.Service;

import xuechuxin.practice.Mapper.xhb_UserMapper;
import xuechuxin.practice.Service.UserService;
import xuechuxin.practice.pojo.xhb_User;
import xuechuxin.pratice.Utils.MD5Util;
import xuechuxin.pratice.Utils.xhb_Result;
/**
 * 用户登录处理
 * <p>Title: LoginServiceImpl</p>
 * <p>author:xuechuxin</p> 
 * @version 1.0
 */
@Service
public class UserService_impl implements UserService{

	@Autowired
	private xhb_UserMapper userMapper;
	
	
	/** 
     * 判断用户登陆是否成功
     * 
     * @param 传入用户名username密码password 
     * @return 返回查询结果result
     */  
	public xhb_Result Userlogin(String username, String password) {
		//根据输入的用户名查询用户
		xhb_User user = userMapper.FindUserByUsername(username);
		//执行查询用户
		if(user ==null ) {
			//返回用户不存在
			return xhb_Result.build(403, "用户不存在");
		}else {		
			//若存在，判断密码是否正确
			//取出符合用户名信息的用户密码进行MD5加密与输入密码进行对比
			String md5Password = MD5Util.MD5(password);
			if(!user.getPassword().equals(md5Password))		
				//密码不一致
				return xhb_Result.build(408, "密码错误");
			else
				//获取用户放入result中
				return xhb_Result.build(200, "登陆成功",user);
		}
		
	}

	
	/** 
     * 判断用户登陆是否成功
     * 
     * @param 传入用户名username
     * @return 返回查询结果result code为200时用户名唯一
     * 
     */  
	public xhb_Result CheckUsername(String username) {
		xhb_User user = userMapper.FindUserByUsername(username);
		//执行查询当user为空时说明用户名唯一
		if(user ==null) {
			return xhb_Result.build(200, "可以使用该用户名");
		}
		else {
			//用户名重复，提示用户重新输入账号
			return xhb_Result.build(400, "用户名重复不能使用");
		}

	}
	
	
	public xhb_Result Checkphone(String phone) {
		xhb_User user = userMapper.FindUserByPhone(phone);
		//执行查询当user为空时说明用户名唯一
		if(user ==null) {
			return xhb_Result.build(200, "该号码可以使用");
		}
		else {
			//用户名重复，提示用户重新输入账号
			return xhb_Result.build(402, "用户已注册，请更换手机号码");
		}

	}


	/** 
     * 注册用户
     * 自动补全部分信息
     * 
     * @return 返回查询结果result.code为200注册成功
     * 
     */  
	public xhb_Result Adduser(xhb_User user) {
		//注册用户，补全用户信息
		//userid 用UUID来填充
		String user_id = UUID.randomUUID().toString();
		System.out.println(user_id);
		user.setUser_id(user_id);
		//加密密码
		String MD5Password = MD5Util.MD5(user.getPassword());
		user.setPassword(MD5Password);
		System.out.println(user.getHeadurl());
		userMapper.CreateUser(user);
		return xhb_Result.build(200, "sucess",user);
	}
}
