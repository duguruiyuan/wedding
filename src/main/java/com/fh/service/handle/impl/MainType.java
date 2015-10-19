package com.fh.service.handle.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.service.handle.AppHandler;
import com.fh.service.system.businessman.BusinessManService;
import com.fh.service.system.dictionaries.MainTypeService;
import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.MainTypeReq;

@Service
@Transactional
public class MainType implements AppHandler {

	@Autowired
	private MainTypeService mainTypeService;

	@Override
	public ResponseBody handle(HttpServletRequest httpServletRequest,
			RequestBody requestBody) {
		return mainTypeService.getMainTypeList((MainTypeReq) requestBody);
	}

}
