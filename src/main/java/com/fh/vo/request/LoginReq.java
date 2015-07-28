package com.fh.vo.request;

import org.hibernate.validator.constraints.NotBlank;

import com.fh.vo.RequestBody;

/**
 * 
 * @author sm
 * 
 */
public class LoginReq extends RequestBody {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1313695554811588484L;

	private String username;

	private String password;

	@NotBlank
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotBlank
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
