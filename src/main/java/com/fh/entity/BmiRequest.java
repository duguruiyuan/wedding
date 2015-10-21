package com.fh.entity;

public class BmiRequest {

	private String name;
	
	private Long manId;

	private String gradeOrder;

	private String salesOrder;

	private String typeId;

	private String pageSize = "10";
	private String pageNo = "1";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public String getPageNo() {
		return pageNo;
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public String getGradeOrder() {
		return gradeOrder;
	}

	public void setGradeOrder(String gradeOrder) {
		this.gradeOrder = gradeOrder;
	}

	public String getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(String salesOrder) {
		this.salesOrder = salesOrder;
	}

	public Long getManId() {
		return manId;
	}

	public void setManId(Long manId) {
		this.manId = manId;
	}

}
