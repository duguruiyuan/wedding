package com.fh.service.handle.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.service.handle.AppHandler;
import com.fh.service.system.validatecode.ValidateCodeService;
import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.CreateVCReq;

//创建验证码
@Service
@Transactional
public class CreateVC implements AppHandler {

	@Autowired
	private ValidateCodeService validateCodeService;

	@Override
	public ResponseBody handle(HttpServletRequest httpServletRequest, RequestBody requestBody) {

		return validateCodeService.createValidateCode((CreateVCReq) requestBody);

	}
}
