package com.fh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.BmiRequest;
import com.fh.entity.BusinessManInfo;
import com.fh.entity.MybatisPageable;

public interface BusinessManInfoMapper {

	List<BusinessManInfo> findBusinessManInfos(
			@Param(value = "request") BmiRequest request,
			@Param(value = "pageable") MybatisPageable pageable);

	Integer countBusinessManInfos(@Param(value = "request") BmiRequest request);
}
