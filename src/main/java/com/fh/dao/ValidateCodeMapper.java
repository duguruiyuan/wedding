package com.fh.dao;

import java.util.Date;

import com.fh.entity.ValidateCode;
import com.fh.util.PageData;

public interface ValidateCodeMapper {
	int deleteByPrimaryKey(Long id);

	int insert(ValidateCode record);

	int insertSelective(ValidateCode record);

	ValidateCode selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(ValidateCode record);

	int updateByPrimaryKey(ValidateCode record);

	ValidateCode findOneByMobileAndExpireTimeGreaterThan(PageData pageData);

	int countByMobileAndCodeAndExpireTimeGreaterThan(PageData pageData);
}