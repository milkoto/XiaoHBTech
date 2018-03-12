package xuechuxin.practice.Controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import xuechuxin.practice.Service.UserService;
import xuechuxin.practice.pojo.xhb_User;
import xuechuxin.pratice.Utils.xhb_Result;

/**
 * 用户相关操作controller
 * <p>Title: UserController</p>
 * <p>author: xuechuxin</p> 
 * @version 1.0
 */

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/api/customer/user/checkusername")
	@ResponseBody
	public xhb_Result CheckUsername(String user_name) {
		xhb_Result result = userService.CheckUsername(user_name);
		
		//返回result
		return result;
	}
	@RequestMapping("/api/customer/user/checkphone")
	@ResponseBody
	public xhb_Result Checkphone(String user_name) {
		xhb_Result result = userService.CheckUsername(user_name);
		
		//返回result
		return result;
	}
	
	@RequestMapping(value="/api/customer/user", method=RequestMethod.POST)
	public String Regist(xhb_User user,HttpServletRequest request,String captcha) throws Exception {
		//取出页面的验证码
		HttpSession session = request.getSession();
		String checked_code = (String)session.getAttribute("captcha");
		captcha=captcha.toUpperCase();
		//判断验证码是否输入正确
		//没有输入验证码或者输入错误
		if( !captcha.equals(checked_code)) {
			xhb_Result result = new xhb_Result(302, "验证码无效", null);
			//重新注册
			request.setAttribute("result", result);
			return "regist";
		}
		//验证码正确
		else {
			//判断图片是否为空
			if(!user.getImage().isEmpty()) {
				//开始上传图片
				//设置图片的名称
				MultipartFile	uploadFile = user.getImage();
				String picName = UUID.randomUUID().toString();		
				//获取源文件的扩展名
				String originalFilename = user.getImage().getOriginalFilename();
				String extName = originalFilename.substring(originalFilename.indexOf("."));
				//设置上传文件夹的地址
				uploadFile.transferTo(new File("G:/java/XHB_Tech/XHB_Tech-Web/src/main/webapp/img/"+picName+extName));
				//得到文件的相对地址和文件名
				String url = "/img/"+picName+extName;
				user.setHeadurl(url);
				xhb_Result result = userService.Adduser(user);
				//注册成功将user信息写入session并且把密码置为空保证用户安全			
				user=(xhb_User) result.getData();		
				user.setPassword("");
				session.setAttribute("user", user);
				
				return "index";
			}
			else {
				//没有上传图片。返回注册失败
				xhb_Result result = new xhb_Result(404, "图片不能为空", null);
				//重新注册
				request.setAttribute("result", result);
				return "regist";
			}
		}
	}
	
	@RequestMapping("/api/customer/user")
	public String userInfo(HttpServletRequest request) {
		//取出session中的user
		xhb_User user = (xhb_User) request.getSession().getAttribute("user");
		request.setAttribute("user", user);
		return "userinfo";
	}
	
}
