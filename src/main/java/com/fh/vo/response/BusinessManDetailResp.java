package com.fh.vo.response;

import com.fh.entity.BusinessManInfo;
import com.fh.vo.ResponseBody;

public class BusinessManDetailResp extends ResponseBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BusinessManInfo businessManInfo;

	public BusinessManInfo getBusinessManInfo() {
		return businessManInfo;
	}

	public void setBusinessManInfo(BusinessManInfo businessManInfo) {
		this.businessManInfo = businessManInfo;
	}
}
