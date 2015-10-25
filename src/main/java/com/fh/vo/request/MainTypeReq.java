package com.fh.vo.request;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.fh.vo.RequestBody;

public class MainTypeReq extends RequestBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Long id;
	
	@NotBlank
	private String level;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

}
