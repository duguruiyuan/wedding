package com.fh.vo.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fh.vo.RequestBody;

public class FavoritesReq extends RequestBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String type;

	private Long productId;

	private Long manId;

	private Boolean flag = Boolean.TRUE;// true 为关注 false 为取消

	@NotBlank
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getManId() {
		return manId;
	}

	public void setManId(Long manId) {
		this.manId = manId;
	}

	@NotNull
	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
}