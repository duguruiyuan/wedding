package com.fh.entity;

public class BusinessManInfo {

	private Long userId;

	private Long typeId;
	
	private String name;

	private String typeName;

	private String address;

	private String remark;

	private Integer grade;

	private Boolean tuanFlag;

	private Boolean cuFlag;

	private Boolean dingFlag;

	private Boolean paiFlag;

	private String mainImageUrl;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public Boolean getTuanFlag() {
		return tuanFlag;
	}

	public void setTuanFlag(Boolean tuanFlag) {
		this.tuanFlag = tuanFlag;
	}

	public Boolean getCuFlag() {
		return cuFlag;
	}

	public void setCuFlag(Boolean cuFlag) {
		this.cuFlag = cuFlag;
	}

	public Boolean getDingFlag() {
		return dingFlag;
	}

	public void setDingFlag(Boolean dingFlag) {
		this.dingFlag = dingFlag;
	}

	public Boolean getPaiFlag() {
		return paiFlag;
	}

	public void setPaiFlag(Boolean paiFlag) {
		this.paiFlag = paiFlag;
	}

	public String getMainImageUrl() {
		return mainImageUrl;
	}

	public void setMainImageUrl(String mainImageUrl) {
		this.mainImageUrl = mainImageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
