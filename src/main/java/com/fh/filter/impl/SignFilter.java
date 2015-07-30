package com.fh.filter.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.fh.constants.AppConstants;
import com.fh.filter.AppFilter;
import com.fh.filter.AppFilterChain;
import com.fh.util.BusinessException;
import com.fh.util.CommonUtil;
import com.fh.util.MapUtil;
import com.fh.util.PropertiesReader;
import com.fh.vo.RequestBody;

@Service
public class SignFilter implements AppFilter {

	@Override
	public void doFilter(RequestBody requestBody, HttpServletRequest httpServletRequest, AppFilterChain appFilterChain) {

		try {
			Map<String, Object> paramters = MapUtil.changeGetParameterMap(httpServletRequest);
			String sign = CommonUtil.getSequenceString(paramters);
			if (!requestBody.getSign().equals(sign)) {
				String key = AppConstants.CODE_114;
				throw new BusinessException(key, PropertiesReader.readAsString(key));
			}
		} catch (Exception e) {
			throw e;
		}
		appFilterChain.doFilter(requestBody, httpServletRequest);
	}
}
