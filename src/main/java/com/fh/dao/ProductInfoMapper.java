package com.fh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.BmiRequest;
import com.fh.entity.BusinessManInfo;
import com.fh.entity.MybatisPageable;
import com.fh.entity.ProductInfo;

public interface ProductInfoMapper {

	List<ProductInfo> findProductInfos(
			@Param(value = "request") BmiRequest request,
			@Param(value = "pageable") MybatisPageable pageable);

	ProductInfo findProductInfo(@Param(value = "id") long id);

}
