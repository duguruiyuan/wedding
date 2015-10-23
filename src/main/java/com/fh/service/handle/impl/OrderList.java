package com.fh.service.handle.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.constants.AppConstants;
import com.fh.service.handle.AppHandler;
import com.fh.service.system.order.OrderService;
import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.OrderListReq;

@Service
@Transactional
public class OrderList implements AppHandler {

	@Autowired
	private OrderService orderService;

	@Override
	public ResponseBody handle(HttpServletRequest httpServletRequest,
			RequestBody requestBody) {
		Long id = (Long) httpServletRequest.getSession().getAttribute(
				AppConstants.SESSION_USER_ID);
		return orderService.orderList((OrderListReq) requestBody, id);
	}

}
