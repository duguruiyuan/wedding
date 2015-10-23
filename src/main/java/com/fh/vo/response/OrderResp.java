package com.fh.vo.response;

import java.util.ArrayList;
import java.util.List;

import com.fh.entity.ShoppingCartInfo;
import com.fh.vo.ResponseBody;

public class OrderResp extends ResponseBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Long> orderIds = new ArrayList<Long>();

	public List<Long> getOrderIds() {
		return orderIds;
	}

	public void setOrderIds(List<Long> orderIds) {
		this.orderIds = orderIds;
	}

}
