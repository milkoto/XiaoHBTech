package xuechuxin.practice.Mapper;

import xuechuxin.practice.pojo.xhb_User;

public interface xhb_UserMapper {
	public xhb_User FindUserById(String user_id);
	public xhb_User FindUserByUsername(String username);
	public xhb_User Userlogin(xhb_User user);
	public Integer  CreateUser(xhb_User user);
	public xhb_User FindUserByPhone(String phone);
}
