package com.fh.filter.impl;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.fh.constants.IYiMingConstants;
import com.fh.filter.AppFilter;
import com.fh.filter.AppFilterChain;
import com.fh.util.BusinessException;
import com.fh.util.PropertiesReader;
import com.fh.vo.RequestBody;

@Service
public class SessionFilter implements AppFilter {

	private static List<String> excludeUrl = Arrays.asList(IYiMingConstants.LoginImpl, IYiMingConstants.CreateVC, IYiMingConstants.Register, IYiMingConstants.GetProjectList, IYiMingConstants.GetProjectDetail, IYiMingConstants.GetVersion);

	@Override
	public void doFilter(RequestBody requestBody, HttpServletRequest httpServletRequest, AppFilterChain appFilterChain) {

		try {
			if (!excludeUrl.contains(requestBody.getMethod())) {
				if (null == httpServletRequest.getSession().getAttribute(IYiMingConstants.SESSION_USER_ID)) {
					String key = IYiMingConstants.CODE_113;
					throw new BusinessException(key, PropertiesReader.readAsString(key));
				}
			}
		} catch (Exception e) {
			throw e;
		}
		appFilterChain.doFilter(requestBody, httpServletRequest);
	}
}
