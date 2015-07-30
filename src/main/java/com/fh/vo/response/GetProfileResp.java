package com.fh.vo.response;

import com.fh.vo.ResponseBody;

public class GetProfileResp extends ResponseBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username;// 登陆用户名
	private String imageUrl;// 头像
	private String phone;// 联系电话
	private String name;// 昵称

	// private String city;// 城市
	// private String sex;// 性别
	// private String realName;// 真实姓名
	// private String address;// 地址

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public String getCity() { return city; }
	 * 
	 * public void setCity(String city) { this.city = city; }
	 * 
	 * public String getSex() { return sex; }
	 * 
	 * public void setSex(String sex) { this.sex = sex; }
	 * 
	 * public String getRealName() { return realName; }
	 * 
	 * public void setRealName(String realName) { this.realName = realName; }
	 * 
	 * public String getAddress() { return address; }
	 * 
	 * public void setAddress(String address) { this.address = address; }
	 */

}
