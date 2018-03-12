package xuechuxin.practice.pojo;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class xhb_User implements Serializable{
	private String user_id;
	private String user_name;
	private String password;
	private String headurl;
	private String phone;
	private long cash_asset;
	private long score_asset;
	private long coin_asset;
	private String real_name;
	private String bankcardno;
	private String bankcardname;
	private int has_userauthfreeze;
	private int has_setloginpwd;
	private int has_setwithdrawpwd;
	private MultipartFile image;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHeadurl() {
		return headurl;
	}
	public void setHeadurl(String headurl) {
		this.headurl = headurl;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Long getCash_asset() {
		return cash_asset;
	}
	public void setCash_asset(long i) {
		this.cash_asset = i;
	}
	public Long getScore_asset() {
		return score_asset;
	}
	public void setScore_asset(long i) {
		this.score_asset = i;
	}
	public Long getCoin_asset() {
		return coin_asset;
	}
	public void setCoin_asset(long i) {
		this.coin_asset = i;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getBankcardno() {
		return bankcardno;
	}
	public void setBankcardno(String bankcardno) {
		this.bankcardno = bankcardno;
	}
	public String getBankcardname() {
		return bankcardname;
	}
	public void setBankcardname(String bankcardname) {
		this.bankcardname = bankcardname;
	}
	public int isHas_userauthfreeze() {
		return has_userauthfreeze;
	}
	public void setHas_userauthfreeze(int i) {
		this.has_userauthfreeze = i;
	}
	public int isHas_setloginpwd() {
		return has_setloginpwd;
	}
	public void setHas_setloginpwd(int i) {
		this.has_setloginpwd = i;
	}
	public int isHas_setwithdrawpwd() {
		return has_setwithdrawpwd;
	}
	public void setHas_setwithdrawpwd(int i) {
		this.has_setwithdrawpwd = i;
	}
	
	
	public String captcha;
	
	
	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	
	 public MultipartFile getImage() {
	        return image;
	    }

	    public void setImage(MultipartFile image) {
	        this.image = image;
	    }   

}
