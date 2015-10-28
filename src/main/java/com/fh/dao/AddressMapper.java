package com.fh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.Address;
import com.fh.entity.MybatisPageable;
import com.fh.vo.request.AddressListReq;

public interface AddressMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Address record);

	int insertSelective(Address record);

	Address selectByPrimaryKey(Long id);
	
	Address selectByDefaultFlag(Boolean defaultFlag);

	int updateByPrimaryKeySelective(Address record);

	int updateByPrimaryKey(Address record);

	List<Address> findAddressList(
			@Param(value = "request") AddressListReq request,
			@Param(value = "userId") Long userId,
			@Param(value = "pageable") MybatisPageable pageable);
}