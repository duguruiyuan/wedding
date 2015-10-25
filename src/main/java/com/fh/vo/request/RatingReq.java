package com.fh.vo.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fh.vo.RequestBody;

//下订单
public class RatingReq extends RequestBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	private Long productId;

	@NotBlank
	private String comment;// 评语

	@NotNull
	private float grade;// 等级，从0到8

	@NotNull
	private Long orderId;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}
