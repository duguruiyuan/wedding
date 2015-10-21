package com.fh.vo.request;

import com.fh.vo.RequestBody;

public class ShoppingReq extends RequestBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long productId;

	private Integer count = 1;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
