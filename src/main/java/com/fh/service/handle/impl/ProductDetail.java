package com.fh.service.handle.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.service.handle.AppHandler;
import com.fh.service.system.product.ProductService;
import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;

@Service
@Transactional
public class ProductDetail implements AppHandler{
	
	@Autowired
	private ProductService productService;

	@Override
	public ResponseBody handle(HttpServletRequest httpServletRequest,
			RequestBody requestBody) {
		return productService.productList(requestBody);
	}

}
