package com.fh.filter.impl;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.constants.AppConstants;
import com.fh.filter.AppFilter;
import com.fh.filter.AppFilterChain;
import com.fh.util.BusinessException;
import com.fh.vo.RequestBody;

/**
 * 
 * @author sm
 * 
 */
@Service
public class RequestBodyJsr303Filter implements AppFilter {

	@Autowired
	private Validator validator;

	@Override
	public void doFilter(RequestBody requestBody, HttpServletRequest httpServletRequest, AppFilterChain appFilterChain) {
		Set<ConstraintViolation<RequestBody>> constraintViolations = validator.validate(requestBody);
		if (constraintViolations.size() > 0) {
			StringBuilder message = new StringBuilder();
			for (ConstraintViolation<RequestBody> constrainViolation : constraintViolations) {
				message.append(constrainViolation.getPropertyPath().toString() + constrainViolation.getMessage() + "|");
			}

			String key = AppConstants.CODE_115;
			throw new BusinessException(key, message.toString());
		}
		appFilterChain.doFilter(requestBody, httpServletRequest);
	}
}
