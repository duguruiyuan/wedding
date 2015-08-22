package com.fh.vo.response;

import java.util.ArrayList;
import java.util.List;

import com.fh.entity.BusinessManInfo;
import com.fh.entity.ProductInfo;
import com.fh.vo.ResponseBody;

public class ProductListResp extends ResponseBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ProductInfo> ProductInfos = new ArrayList<ProductInfo>();

	public List<ProductInfo> getProductInfos() {
		return ProductInfos;
	}

	public void setProductInfos(List<ProductInfo> productInfos) {
		ProductInfos = productInfos;
	}

}
