package com.fh.service.handle.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.constants.AppConstants;
import com.fh.service.handle.AppHandler;
import com.fh.service.system.appuser.AppuserService;
import com.fh.service.system.file.FileService;
import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.CompleteProfileReq;

@Service
@Transactional
public class CompleteProfile implements AppHandler {

	@Autowired
	private AppuserService userService;

	@Override
	public ResponseBody handle(HttpServletRequest httpServletRequest,
			RequestBody requestBody) {
		Long id = (Long) httpServletRequest.getSession().getAttribute(
				AppConstants.SESSION_USER_ID);
		return userService.completeProfile((CompleteProfileReq) requestBody,
				id, httpServletRequest);

	}

}
