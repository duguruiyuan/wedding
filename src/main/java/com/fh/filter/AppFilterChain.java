package com.fh.filter;

import javax.servlet.http.HttpServletRequest;

import com.fh.vo.RequestBody;

public interface AppFilterChain {

	public void doFilter(RequestBody requestBody, HttpServletRequest httpServletRequest);

}
