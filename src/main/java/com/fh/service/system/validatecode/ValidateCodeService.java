package com.fh.service.system.validatecode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ValidateCodeService {
	@Value(value = "${vcTimeOut?:5}")
	private int vcTimeOut;

}
