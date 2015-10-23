package com.fh.vo.request;

/**
 * 
 * @author sm
 * 
 */
public class OrderListReq extends PageRequest {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1313695554811588484L;

	private String flowId;

	public String getFlowId() {
		return flowId;
	}

	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}

}
