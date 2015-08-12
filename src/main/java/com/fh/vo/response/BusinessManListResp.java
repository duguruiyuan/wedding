package com.fh.vo.response;

import java.util.ArrayList;
import java.util.List;

import com.fh.entity.BusinessManInfo;
import com.fh.vo.ResponseBody;

public class BusinessManListResp extends ResponseBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<BusinessManInfo> businessManInfos = new ArrayList<BusinessManInfo>();

	public List<BusinessManInfo> getBusinessManInfos() {
		return businessManInfos;
	}

	public void setBusinessManInfos(List<BusinessManInfo> businessManInfos) {
		this.businessManInfos = businessManInfos;
	}

}
