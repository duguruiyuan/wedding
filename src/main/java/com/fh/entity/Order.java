package com.fh.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Long id;

	private String flowId ="未付款";

    private BigDecimal totalPrice;

    private Long userId;

    private Date createdDate;

    private Date payTime;

    private Long businessManId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}