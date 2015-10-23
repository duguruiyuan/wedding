package com.fh.vo.request;

import java.util.ArrayList;
import java.util.List;

import com.fh.vo.RequestBody;

//下订单
public class OrderReq extends RequestBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String orderLists;

	private List<OrderDetail> orderList = new ArrayList<OrderDetail>();

	public static class OrderDetail {

		private Long productId;

		private Long shoppingCartId;

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

		public Long getShoppingCartId() {
			return shoppingCartId;
		}

		public void setShoppingCartId(Long shoppingCartId) {
			this.shoppingCartId = shoppingCartId;
		}

	}

	public List<OrderDetail> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderDetail> orderList) {
		this.orderList = orderList;
	}

	public String getOrderLists() {
		return orderLists;
	}

	public void setOrderLists(String orderLists) {
		this.orderLists = orderLists;
	}
}
