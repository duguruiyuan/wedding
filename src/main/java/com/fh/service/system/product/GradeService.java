package com.fh.service.system.product;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.dao.GradeInfoMapper;
import com.fh.dao.GradeMapper;
import com.fh.entity.Grade;
import com.fh.entity.GradeInfo;
import com.fh.entity.MybatisPageable;
import com.fh.vo.ErrorResponseBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.RatingListReq;
import com.fh.vo.request.RatingReq;
import com.fh.vo.response.RatingListResp;

@Service
@Transactional
public class GradeService {

	@Autowired
	GradeMapper gradeMapper;

	@Autowired
	GradeInfoMapper gradeInfoMapper;

	public ResponseBody rating(RatingReq ratingReq, Long userId) {
		Grade grade = gradeMapper.selectByUserIdAndProductIdAndOrderId(userId,
				ratingReq.getProductId(), ratingReq.getOrderId());
		if (null != grade)
			return ErrorResponseBody.createErrorResponseBody("已评价过");
		grade = new Grade();
		grade.setComment(ratingReq.getComment());
		grade.setProductId(ratingReq.getProductId());
		grade.setGrade(ratingReq.getGrade());
		grade.setUserId(userId);
		grade.setCreateTime(new Date());
		grade.setOrderId(ratingReq.getOrderId());
		gradeMapper.insert(grade);
		return ResponseBody.createResponseBody("000000");

	}

	public ResponseBody ratingList(RatingListReq ratingReq) {
		List<GradeInfo> list = gradeInfoMapper.findGradeInfos(ratingReq
				.getProductId(), ratingReq.getBusinessManId(),
				new MybatisPageable(Integer.valueOf(ratingReq.getPageSize()),
						Integer.valueOf(ratingReq.getPageNo())));
		RatingListResp listResp = new RatingListResp();
		listResp.setStatus("000000");
		listResp.setGradeInfos(list);
		return listResp;
	}
}
