package com.fh.vo.response;

import java.util.ArrayList;
import java.util.List;

import com.fh.entity.BusinessManInfo;
import com.fh.entity.GradeInfo;
import com.fh.entity.OrderInfo;
import com.fh.entity.ProductInfo;
import com.fh.vo.ResponseBody;

public class RatingListResp extends ResponseBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<GradeInfo> gradeInfos = new ArrayList<GradeInfo>();

	public List<GradeInfo> getGradeInfos() {
		return gradeInfos;
	}

	public void setGradeInfos(List<GradeInfo> gradeInfos) {
		this.gradeInfos = gradeInfos;
	}

}
