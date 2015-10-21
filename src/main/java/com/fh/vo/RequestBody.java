package com.fh.vo;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class RequestBody implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * API接口名称
	 */
	private String method;

	/**
	 * 客户端传入参数，对其值进行倒序排序后，再进行拼接，然后MD5加密
	 */
	private String sign;

	@NotBlank
	@Size(max = 100)
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@NotBlank
	@Size(max = 100)
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}



	
}
