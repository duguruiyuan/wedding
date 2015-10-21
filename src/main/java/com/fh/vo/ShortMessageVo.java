package com.fh.vo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;

import com.fh.util.MapUtil;

public class ShortMessageVo implements HttpVo {

	private MultiValueMap<String, Object> entity;

	public ShortMessageVo() {
	}

	public ShortMessageVo(String apikey, String mobile, String text) {
		this.apikey = apikey;
		this.mobile = mobile;
		this.setText(text);
		setEntity(MapUtil.convertHttpBean(this));
	}

	private String apikey;// id
	private String mobile;// 全部被叫号码
	private String text;// 发送内容

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "用户ID:" + apikey + "全部被叫号码:" + mobile + "发送内容:" + text;
	}

	public MultiValueMap<String, Object> getEntity() {
		return entity;
	}

	public void setEntity(MultiValueMap<String, Object> entity) {
		this.entity = entity;
	}

	@Override
	public HttpEntity<MultiValueMap<String, Object>> createEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		return new HttpEntity<MultiValueMap<String, Object>>(getEntity(),
				headers);

	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}