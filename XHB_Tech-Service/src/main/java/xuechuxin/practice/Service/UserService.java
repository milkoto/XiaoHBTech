package xuechuxin.practice.Service;

import xuechuxin.practice.pojo.xhb_User;
import xuechuxin.pratice.Utils.xhb_Result;

public interface UserService {

	

	public xhb_Result Userlogin(String username, String password);

	public xhb_Result CheckUsername(String user_name);
	public xhb_Result Checkphone(String user_name);

	public xhb_Result Adduser(xhb_User user);
	
}
