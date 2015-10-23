package com.fh.vo.response;

import java.util.ArrayList;
import java.util.List;

import com.fh.entity.BusinessManInfo;
import com.fh.entity.OrderInfo;
import com.fh.entity.ProductInfo;
import com.fh.vo.ResponseBody;

public class OrderListResp extends ResponseBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<OrderInfo> orderInfos = new ArrayList<OrderInfo>();

	public List<OrderInfo> getOrderInfos() {
		return orderInfos;
	}

	public void setOrderInfos(List<OrderInfo> orderInfos) {
		this.orderInfos = orderInfos;
	}

}
