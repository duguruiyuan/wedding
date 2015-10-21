package com.fh.vo.request;

import javax.validation.constraints.NotNull;

import com.fh.vo.RequestBody;

public class BusinessManDetailReq extends RequestBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
