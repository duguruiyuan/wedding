package com.fh.vo;

import org.springframework.http.HttpEntity;
import org.springframework.util.MultiValueMap;

public interface HttpVo {

	public HttpEntity<MultiValueMap<String, Object>> createEntity();

}
