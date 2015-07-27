package com.fh.vo;

import com.fh.constants.AppConstants;

public class ErrorResponseBody extends ResponseBody {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5406188646545695869L;

	public static ErrorResponseBody createErrorResponseBody(String memo) {
		ErrorResponseBody responseBody = new ErrorResponseBody();
		responseBody.setStatus(AppConstants.CODE_111);
		responseBody.setMemo(memo);
		return responseBody;
	}
	
	public static ErrorResponseBody createErrorResponseBody(String status,String memo) {
		ErrorResponseBody responseBody = new ErrorResponseBody();
		responseBody.setStatus(status);
		responseBody.setMemo(memo);
		return responseBody;
	}

}
