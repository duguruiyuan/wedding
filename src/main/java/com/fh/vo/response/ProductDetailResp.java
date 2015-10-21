package com.fh.vo.response;

import com.fh.entity.ProductInfo;
import com.fh.vo.ResponseBody;

public class ProductDetailResp extends ResponseBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ProductInfo ProductInfo;

	public ProductInfo getProductInfo() {
		return ProductInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		ProductInfo = productInfo;
	}

}
