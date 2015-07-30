package com.fh.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fh.filter.AppFilterChain;
import com.fh.service.system.file.FileService;
import com.fh.vo.RequestBody;

@Service
public class GetFileService {

	/*@Autowired
	private AppFilterChain fileFilterChain;*/

	@Autowired
	private FileService fileService;

	public byte[] getAvatar(HttpServletRequest httpServletRequest)
			throws IOException {
		/*fileFilterChain.doFilter(new RequestBody(), httpServletRequest);*/
		return fileService.getAvatar(httpServletRequest);
	}

}
