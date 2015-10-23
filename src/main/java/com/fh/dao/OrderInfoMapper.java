package com.fh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.BmiRequest;
import com.fh.entity.BusinessManInfo;
import com.fh.entity.MybatisPageable;
import com.fh.entity.OrderInfo;
import com.fh.entity.OrderPageRequest;
import com.fh.entity.ProductInfo;

public interface OrderInfoMapper {

	List<OrderInfo> findOrderInfos(
			@Param(value = "request") OrderPageRequest request,
			@Param(value = "pageable") MybatisPageable pageable);

	OrderInfo findOrderInfo(@Param(value = "id") long id);

}
