package com.fh.vo.request;

import javax.validation.constraints.NotNull;

public class AddressListReq extends PageRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Boolean defaultFlag;

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