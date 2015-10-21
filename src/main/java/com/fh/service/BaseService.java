package com.fh.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.constants.AppConstants;
import com.fh.filter.AppFilterChain;
import com.fh.filter.IYiMingSession;
import com.fh.service.handle.AppHandler;
import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;

@Service
public class BaseService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private Map<String, AppHandler> appHandlers;

	@Autowired
	private AppFilterChain appFilterChain;

	public ResponseBody handle(HttpServletRequest httpServletRequest,
			String method) throws IOException, InterruptedException {
		RequestBody requestBody = new RequestBody();
		requestBody.setMethod(method);
		logger.info(httpServletRequest.getMethod());
		logger.info(getParameters(httpServletRequest));

		appFilterChain.doFilter(requestBody, httpServletRequest);
		requestBody = (RequestBody) IYiMingSession.get("requestBody");
		IYiMingSession.clear();

		ResponseBody responseBody = executeTask(httpServletRequest, requestBody);
		return responseBody;
	}

	/**
	 * 
	 * @description: 执行任务
	 * @author: wujinsong
	 * @param httpServletRequest
	 * @param requestBody
	 * @return
	 */
	private ResponseBody executeTask(HttpServletRequest httpServletRequest,
			RequestBody requestBody) {
		ResponseBody responseBody = null;
		responseBody = appHandlers.get(
				AppConstants.APP_HANDLER.get(requestBody.getMethod()))
				.handle(httpServletRequest, requestBody);
		logger.debug("接口调用成功!");
		return responseBody;
	}

	public String getParameters(HttpServletRequest httpServletRequest) {
		Map<String, String[]> params = httpServletRequest.getParameterMap();
		String queryString = "";
		for (String key : params.keySet()) {
			String[] values = params.get(key);
			for (int i = 0; i < values.length; i++) {
				String value = values[i];
				queryString += key + "=" + value + "&";
			}
		}
		// 去掉最后一个空格
		return queryString.substring(0, queryString.length() - 1);
	}

}
