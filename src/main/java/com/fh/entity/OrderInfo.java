package com.fh.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderInfo {
	private Long id;

	private String flowId;

	private BigDecimal totalPrice;
	
	private BigDecimal totalNoDealPrice;//未支付金额

	private Date createdDate;

	private Date payTime;

	private Long businessManId;
	
	private String businessManName;

	private List<OrderDetailInfo> orderDetails = new ArrayList<OrderDetailInfo>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId == null ? null : flowId.trim();
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}



	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Long getBusinessManId() {
		return businessManId;
	}

	public void setBusinessManId(Long businessManId) {
		this.businessManId = businessManId;
	}

	public List<OrderDetailInfo> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailInfo> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public BigDecimal getTotalNoDealPrice() {
		return totalNoDealPrice;
	}

	public void setTotalNoDealPrice(BigDecimal totalNoDealPrice) {
		this.totalNoDealPrice = totalNoDealPrice;
	}

	public String getBusinessManName() {
		return businessManName;
	}

	public void setBusinessManName(String businessManName) {
		this.businessManName = businessManName;
	}
}