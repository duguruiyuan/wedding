package com.fh.service.system.validatecode;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.dao.ValidateCodeMapper;
import com.fh.entity.ValidateCode;
import com.fh.util.PageData;
import com.fh.util.ValidateCodeUtil;
import com.fh.vo.ErrorResponseBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.CreateVCReq;
import com.fh.vo.request.RegisterReq;

@Service
@Transactional
public class ValidateCodeService {

	@Autowired
	private ValidateCodeMapper validateCodeMapper;
	@Autowired
	private SmsService smsService;

	@Value(value = "${vcTimeOut?:5}")
	private int vcTimeOut;

	/**
	 * @author SM
	 * @description 新建手机验证码
	 */
	public ResponseBody createValidateCode(CreateVCReq createVCReq) {

		PageData pageData = new PageData();
		pageData.put("phone", createVCReq.getPhone());
		pageData.put("expireTime", DateTime.now().toDate());
		ValidateCode validateCode = validateCodeMapper
				.findOneByMobileAndExpireTimeGreaterThan(pageData);
		// 是否已经生成
		if (null != validateCode) {
			return ErrorResponseBody.createErrorResponseBody("验证码" + vcTimeOut
					+ "分钟内不可重复申请!");
		} else {
			String code = ValidateCodeUtil.generate6RandomNum();
			validateCode = new ValidateCode();
			validateCode.setCode(code);
			validateCode.setExpireTime(DateTime.now().plusMinutes(vcTimeOut)
					.toDate());
			validateCode.setMobile(createVCReq.getPhone());
			validateCodeMapper.insert(validateCode);
			if (smsService.sendSms(code, createVCReq.getPhone()))
				return ResponseBody.createResponseBody("创建验证码成功");
			return ErrorResponseBody.createErrorResponseBody("短信发送失败");
		}

	}

	public boolean validataCodeCheck(RegisterReq registerReq) {
		PageData pageData = new PageData();
		pageData.put("phone", registerReq.getPhone());
		pageData.put("expireTime", DateTime.now().toDate());
		pageData.put("validateCode", registerReq.getValidateCode());
		return validateCodeMapper
				.countByMobileAndCodeAndExpireTimeGreaterThan(pageData) > 0 ? true
				: false;

	}

}
