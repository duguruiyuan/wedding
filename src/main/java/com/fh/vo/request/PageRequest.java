package com.fh.vo.request;

import com.fh.vo.RequestBody;

public class PageRequest extends RequestBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pageSize = "10";
	private String pageNo = "1";
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
