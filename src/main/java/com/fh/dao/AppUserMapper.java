package com.fh.dao;

import com.fh.entity.AppUser;
import com.fh.util.PageData;

public interface AppUserMapper {
	int deleteByPrimaryKey(Long userId);

	int insert(AppUser record);

	int insertSelective(AppUser record);

	AppUser selectByPrimaryKey(Long userId);

	int updateByPrimaryKeySelective(AppUser record);

	int updateByPrimaryKey(AppUser record);

	int countByUsername(String userName);
	
	int countByName(String name);

	int countByMobile(String mobile);

	AppUser findByUsername(String userName);
	
	AppUser findByName(String name);

	AppUser findByThirdTypeAndOpenId(PageData data);
}