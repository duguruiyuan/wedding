package com.fh.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fh.constants.AppConstants;
import com.fh.service.BaseService;
import com.fh.util.BusinessException;
import com.fh.util.PropertiesReader;
import com.fh.vo.ErrorResponseBody;
import com.fh.vo.ResponseBody;

/**
 * 
 * @description: 统一入口
 * @author: SM
 */
@RestController
@RequestMapping(value = "/rest")
public class AllController {

	@Autowired
	private BaseService baseService;

	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseBody handle(HttpServletRequest httpServletRequest,
			 String method) throws IOException,
			InterruptedException {
		return baseService.handle(httpServletRequest, method);
	}

	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseBody handleIOException(BusinessException e) {
		e.printStackTrace();
		ErrorResponseBody responseBody = ErrorResponseBody
				.createErrorResponseBody(e.getCode(), e.getMessage());
		return responseBody;
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseBody handleIOException(Exception e) {
		e.printStackTrace();
		String key = AppConstants.CODE_999;
		String value = PropertiesReader.readAsString(key);
		ErrorResponseBody responseBody = ErrorResponseBody
				.createErrorResponseBody(key, value);
		return responseBody;
	}
}
