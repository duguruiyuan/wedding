package com.fh.service.handle;

import javax.servlet.http.HttpServletRequest;

import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;

/**
 * 
 * @description: 接口处理器
 * @author: SM
 */
public interface AppHandler {

	/* 处理接口请求 */
	ResponseBody handle(HttpServletRequest httpServletRequest, RequestBody requestBody);
}
