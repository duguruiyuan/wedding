package com.fh.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fh.constants.AppConstants;
import com.fh.service.GetFileService;
import com.fh.util.BusinessException;
import com.fh.util.PropertiesReader;
import com.fh.vo.ErrorResponseBody;
import com.fh.vo.ResponseBody;

@RestController
@RequestMapping(value = "/file")
public class FileController {

	@Autowired
	private GetFileService getFileService;

	@RequestMapping(value = "/getAvatar/{id}", method = { RequestMethod.GET })
	public void getAvatar(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse, @PathVariable Long id)
			throws IOException, InterruptedException {
		httpServletResponse.setContentType("image/png");
		OutputStream outputStream = new BufferedOutputStream(
				httpServletResponse.getOutputStream());
		outputStream.write(getFileService.getAvatar(httpServletRequest, id));
		outputStream.flush();
		outputStream.close();
	}

	/*
	 * @RequestMapping(value = "/getProjectImage/{id}/{version}", method = {
	 * RequestMethod.GET }) public void getAvatar(HttpServletRequest
	 * httpServletRequest, HttpServletResponse httpServletResponse,
	 * @PathVariable Long id, @PathVariable Long version) throws IOException,
	 * InterruptedException { httpServletResponse.setContentType("image/png");
	 * OutputStream outputStream = new
	 * BufferedOutputStream(httpServletResponse.getOutputStream());
	 * outputStream.write(getFileService.getProjectImage(httpServletRequest,
	 * id)); outputStream.flush(); outputStream.close(); }
	 */
	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
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
