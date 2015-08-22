package com.fh.vo.request;

/**
 * 
 * @author sm
 * 
 */
public class ProductListReq extends PageRequest {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1313695554811588484L;

	private String name;

	private boolean gradeOrder;

	private boolean salesOrder;

	private String typeId;

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

}
