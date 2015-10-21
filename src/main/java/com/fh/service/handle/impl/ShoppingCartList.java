package com.fh.service.handle.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.constants.AppConstants;
import com.fh.service.handle.AppHandler;
import com.fh.service.system.businessman.BusinessManService;
import com.fh.service.system.shopping.ShoppingCartService;
import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;

@Service
@Transactional
public class ShoppingCartList implements AppHandler {

	@Autowired
	private ShoppingCartService shoppingCartService;

	@Override
	public ResponseBody handle(HttpServletRequest httpServletRequest,
			RequestBody requestBody) {
		Long id = (Long) httpServletRequest.getSession().getAttribute(
				AppConstants.SESSION_USER_ID);
		return shoppingCartService.shoppingCartList(requestBody, id);
	}

}
