package com.fh.service.handle.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.service.handle.AppHandler;
import com.fh.service.system.appuser.AppuserService;
import com.fh.service.system.validatecode.ValidateCodeService;
import com.fh.vo.ErrorResponseBody;
import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.RegisterReq;

@Service
@Transactional
public class Register implements AppHandler {

	@Autowired
	private AppuserService userService;

	@Autowired
	private ValidateCodeService validateCodeService;

	@Override
	public ResponseBody handle(HttpServletRequest httpServletRequest,
			RequestBody requestBody) {
		RegisterReq registerReq = (RegisterReq) requestBody;
		if (validateCodeService.validataCodeCheck(registerReq))
			return userService.register(registerReq);
		return ErrorResponseBody.createErrorResponseBody("手机号和验证码不匹配!");

	}
}
