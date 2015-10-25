package com.fh.vo.response;

import java.util.List;

import com.fh.entity.MainTypeInfo;
import com.fh.vo.ResponseBody;

public class MainTypeResp extends ResponseBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<MainTypeInfo> mainTypeInfos;

	public List<MainTypeInfo> getMainTypeInfos() {
		return mainTypeInfos;
	}

	public void setMainTypeInfos(List<MainTypeInfo> mainTypeInfos) {
		this.mainTypeInfos = mainTypeInfos;
	}
}
