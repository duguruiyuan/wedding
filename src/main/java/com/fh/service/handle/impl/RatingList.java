package com.fh.service.handle.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.constants.AppConstants;
import com.fh.service.handle.AppHandler;
import com.fh.service.system.product.GradeService;
import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.RatingListReq;
import com.fh.vo.request.RatingReq;

@Service
@Transactional
public class RatingList implements AppHandler {

	@Autowired
	private GradeService gradeService;

	@Override
	public ResponseBody handle(HttpServletRequest httpServletRequest,
			RequestBody requestBody) {
		return gradeService.ratingList((RatingListReq) requestBody);
	}

}
