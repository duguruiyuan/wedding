package com.fh.vo.request;

import org.hibernate.validator.constraints.NotBlank;

public class FavoritesListReq extends PageRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String type;

	@NotBlank
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

}