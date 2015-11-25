package com.fh.vo;

/**
 * 
 * @author jswul
 *
 */
public class BehaviorVo {
	/**
	 * 行为类型
	 */
	private String type;
	
	/**
	 * 关联对象id
	 */
	private String relationId;
	
	/**
	 * 关联用户
	 */
	private String appUserId;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRelationId() {
		return relationId;
	}

	public void setRelationId(String relationId) {
		this.relationId = relationId;
	}

	public String getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(String appUserId) {
		this.appUserId = appUserId;
	}
}
