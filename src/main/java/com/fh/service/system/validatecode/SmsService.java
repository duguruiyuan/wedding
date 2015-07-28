package com.fh.service.system.validatecode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestOperations;

import com.fh.constants.AppConstants;
import com.fh.constants.F;
import com.fh.dao.ShortMessageMapper;
import com.fh.entity.ShortMessage;
import com.fh.vo.ShortMessageResp;
import com.fh.vo.ShortMessageVo;

@Service
@Transactional
public class SmsService {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private RestOperations restClient;

	@Autowired
	private ShortMessageMapper shortMessageMapper;

	@Value(value = "${apikey}")
	private String apikey;
	@Value(value = "${sms_url?:http://yunpian.com/v1/sms/send.json}")
	private String url;
	@Value(value = "${vcTimeOut?:5}")
	private int vcTimeOut;

	// @Async
	public boolean sendSms(String code, String mobile) {
		String nr = "【旧文社区】您的验证码是" + code + "。如非本人操作，请忽略本短信";
		ShortMessageVo shortMessageVo = new ShortMessageVo(apikey, mobile, nr);

		String result = restClient.postForObject(url,
				shortMessageVo.createEntity(), String.class);
		ShortMessageResp shortMessageResp = AppConstants.GSON.fromJson(result,
				ShortMessageResp.class);

		ShortMessage shortMessage = new ShortMessage();

		shortMessage.setContent(shortMessageVo.toString());
		shortMessage.setType(AppConstants.MESSAGE_VC);
		if (!shortMessageResp.getCode().equals("0")) {
			logger.warn("短信发送失败," + shortMessageVo.toString());
			shortMessage.setFlowId(F.ShortMessage.FAILED);
		}
		shortMessage.setRespContent(result);
		shortMessageMapper.insert(shortMessage);
		if (shortMessage.getFlowId().equals(F.ShortMessage.SUCCESS))
			return true;
		return false;
	}
}
