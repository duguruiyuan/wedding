package com.fh.vo.response;

import java.util.ArrayList;
import java.util.List;

import com.fh.entity.ShoppingCartInfo;
import com.fh.vo.ResponseBody;

public class ShoppingCartListResp extends ResponseBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<ShoppingCartInfo> shoppingCartList = new ArrayList<ShoppingCartInfo>();

	public List<ShoppingCartInfo> getShoppingCartList() {
		return shoppingCartList;
	}

	public void setShoppingCartList(List<ShoppingCartInfo> shoppingCartList) {
		this.shoppingCartList = shoppingCartList;
	}

}
