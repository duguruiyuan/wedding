package com.fh.entity;

public class BmiRequest {

	private String name;

	private boolean gradeOrder;

	private boolean salesOrder;

	private String typeId;

	private String pageSize = "10";
	private String pageNo = "1";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGradeOrder() {
		return gradeOrder;
	}

	public void setGradeOrder(boolean gradeOrder) {
		this.gradeOrder = gradeOrder;
	}

	public boolean isSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(boolean salesOrder) {
		this.salesOrder = salesOrder;
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

}
