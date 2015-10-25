package com.fh.vo.request;

import javax.validation.constraints.NotNull;

//评价列表
public class RatingListReq extends PageRequest {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private Long productId;

	
	private Long businessManId;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getBusinessManId() {
		return businessManId;
	}

	public void setBusinessManId(Long businessManId) {
		this.businessManId = businessManId;
	}

}
