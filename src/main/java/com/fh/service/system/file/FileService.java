package com.fh.service.system.file;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fh.constants.AppConstants;
import com.fh.dao.AppUserMapper;
import com.fh.service.system.appuser.AppuserService;
import com.fh.util.FileUtil;
import com.fh.vo.ResponseBody;

@Service
@Transactional
public class FileService {

	@Autowired
	private AppUserMapper appUserMapper;
	@Autowired
	private AppuserService appuserService;

	public void uploadAvatar(MultipartHttpServletRequest request) {
		Long id = (Long) request.getSession().getAttribute(
				AppConstants.SESSION_USER_ID);
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf;
		while (itr.hasNext()) {
			String enterpriseCertificateType = itr.next();
			mpf = request.getFile(enterpriseCertificateType);
			if (StringUtils.isEmpty(mpf.getOriginalFilename()))
				continue;
			try {
				String imageUrl = FileUtil.upload(
						FileUtil.builderUploadPath("avatar", id),
						FileUtil.builderNewFileName(mpf.getOriginalFilename()),
						mpf.getInputStream());
				appuserService.uploadImage(id, imageUrl);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

	}

	public byte[] getAvatar(HttpServletRequest httpServletRequest)
			throws IOException {
		Long id = (Long) httpServletRequest.getSession().getAttribute(
				AppConstants.SESSION_USER_ID);
		return getAvatar(id);

	}

	public byte[] getAvatar(Long id) throws IOException {
		if (StringUtils.isEmpty(appUserMapper.selectByPrimaryKey(id)
				.getImageUrl()))
			return new byte[0];
		else
			return FileUtil.download(appUserMapper.selectByPrimaryKey(id)
					.getImageUrl());

	}
}
