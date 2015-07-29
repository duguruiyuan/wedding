package com.fh.service.handle.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.service.handle.AppHandler;
import com.fh.service.system.appuser.AppuserService;
import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.EditPwdReq;

@Service
@Transactional
public class EditPwd implements AppHandler {
	@Autowired
	private AppuserService userService;

	@Override
	public ResponseBody handle(HttpServletRequest httpServletRequest, RequestBody requestBody) {
		EditPwdReq editPwdReq = (EditPwdReq) requestBody;

		return userService.changePassword(httpServletRequest, editPwdReq.getOldPassword(), editPwdReq.getNewPassword(), editPwdReq.getNewPassword2());
	}
}
