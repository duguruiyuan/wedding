package com.fh.vo.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fh.vo.RequestBody;

public class AddressReq extends RequestBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String phone;

	private String provinceCity;

	private String address;

	private String postcode;

	private Boolean defaultFlag;

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	@NotBlank
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}

	@NotBlank
	public String getProvinceCity() {
		return provinceCity;
	}

	public void setProvinceCity(String provinceCity) {
		this.provinceCity = provinceCity == null ? null : provinceCity.trim();
	}

	@NotBlank
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode == null ? null : postcode.trim();
	}

	@NotNull
	public Boolean getDefaultFlag() {
		return defaultFlag;
	}

	public void setDefaultFlag(Boolean defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}