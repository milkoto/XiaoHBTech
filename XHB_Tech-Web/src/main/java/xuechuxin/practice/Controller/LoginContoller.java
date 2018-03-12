package xuechuxin.practice.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import xuechuxin.practice.Service.UserService;
import xuechuxin.practice.pojo.xhb_User;
import xuechuxin.pratice.Utils.xhb_Result;

/**
 * 用户登录处理
 * Title: LoginController</p>
 * Author: xuechuxin</p> 
 * @version 1.0
 */

@Controller
public class LoginContoller {
	
	

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/api/customer/token", method=RequestMethod.POST)
	public String Login(String user_name, String password,
			HttpServletRequest request, HttpServletResponse response,String captcha) {
		//取出页面的验证码
		HttpSession session = request.getSession();
		String checked_code = (String)session.getAttribute("captcha");
		captcha=captcha.toUpperCase();
		//判断验证码是否输入正确
		//没有输入验证码或者输入错误
		System.out.println( !captcha.equals(checked_code));
		if( !captcha.equals(checked_code)) {
			xhb_Result result = new xhb_Result(302, "验证码无效", null);
			//返回错误原因并且重新登陆
			request.setAttribute("result", result);
			return "login";
		}
		//验证码正确
		//判断登陆是否成功
		else{
			xhb_Result result = userService.Userlogin(user_name,password);
				//登陆成功则将user信息写入cookie
			if(result.getCode()==200) {
				xhb_User user = (xhb_User) result.getData();
				//将密码设置为空保证安全
				user.setPassword("");
				session.setAttribute("user", user);
				//request.setAttribute("user", user);
				return "index";
			}
			else {
				//返回错误原因
				request.setAttribute("result", result);
				return "login";
			}
		}
	}


	
}
