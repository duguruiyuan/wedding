package com.fh.vo.response;

import java.util.ArrayList;
import java.util.List;

import com.fh.entity.Address;
import com.fh.entity.BusinessManInfo;
import com.fh.entity.ProductInfo;
import com.fh.vo.ResponseBody;

public class FavoritesListResp extends ResponseBody {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ProductInfo> productList = new ArrayList<ProductInfo>();

	private List<BusinessManInfo> businessManList = new ArrayList<BusinessManInfo>();

	public List<ProductInfo> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductInfo> productList) {
		this.productList = productList;
	}

	public List<BusinessManInfo> getBusinessManList() {
		return businessManList;
	}

	public void setBusinessManList(List<BusinessManInfo> businessManList) {
		this.businessManList = businessManList;
	}

}