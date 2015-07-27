package com.fh.service.handle.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.service.handle.AppHandler;
import com.fh.service.system.appuser.AppuserService;
import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.RegisterReq;
import com.fh.vo.request.ThirdRegisterReq;

@Service
@Transactional
public class ThirdRegister implements AppHandler {

	@Autowired
	private AppuserService userService;

	/*
	 * @Autowired private ValidateCodeService validateCodeService;
	 */

	@Override
	public ResponseBody handle(HttpServletRequest httpServletRequest,
			RequestBody requestBody) {
		ThirdRegisterReq registerReq = (ThirdRegisterReq) requestBody;
		/* if (validateCodeService.validataCodeCheck(registerReq)) */
		return userService.thirdRegister(registerReq);
		/*
		 * else return ErrorResponseBody.createErrorResponseBody("手机号和验证码不匹配!");
		 */
	}
}
