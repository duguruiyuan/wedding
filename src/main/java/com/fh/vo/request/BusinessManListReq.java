package com.fh.vo.request;

/**
 * 
 * @author sm
 * 
 */
public class BusinessManListReq extends PageRequest {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1313695554811588484L;

	private String name;

	private String gradeOrder;

	private String salesOrder;

	private String typeId;

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

}
