package com.fh.entity;

public class BusinessMan {
    private Long userId;

    private Long typeId;

    private String remark;

    private Integer grade;

    private Boolean tuanFlag;

    private Boolean cuFlag;

    private Boolean dingFlag;

    private Boolean paiFlag;

    private Long mainImageId;

    private String address;

    private Long salesCount;

    private String phone;

    private String name;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public Long getMainImageId() {
        return mainImageId;
    }

    public void setMainImageId(Long mainImageId) {
        this.mainImageId = mainImageId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(Long salesCount) {
        this.salesCount = salesCount;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}