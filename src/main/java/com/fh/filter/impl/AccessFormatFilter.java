package com.fh.filter.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.fh.constants.AppConstants;
import com.fh.filter.AppFilter;
import com.fh.filter.AppFilterChain;
import com.fh.filter.IYiMingSession;
import com.fh.util.BusinessException;
import com.fh.util.MapUtil;
import com.fh.util.PropertiesReader;
import com.fh.vo.RequestBody;

/**
 * 
 * @author sm
 * 
 */
@Service
public class AccessFormatFilter implements AppFilter {

	@Override
	public void doFilter(RequestBody requestBody, HttpServletRequest httpServletRequest, AppFilterChain appFilterChain) {
		RequestBody newBody;
		try {
			Map<String, String[]> paramters = httpServletRequest.getParameterMap();
			// 参数map转化为bean
			newBody = (RequestBody) MapUtil.convertMap(AppConstants.APP_VO.get(requestBody.getMethod()), paramters);
			IYiMingSession.put("requestBody", newBody);
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new BusinessException(AppConstants.CODE_115, PropertiesReader.readAsString(AppConstants.CODE_115));
		}
		appFilterChain.doFilter(newBody, httpServletRequest);
	}
}
