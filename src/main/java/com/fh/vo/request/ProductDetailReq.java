package com.fh.vo.request;

import com.fh.vo.RequestBody;

/**
 * 
 * @author sm
 * 
 */
public class ProductDetailReq extends RequestBody {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1313695554811588484L;

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
