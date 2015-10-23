package com.fh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.OrderDetailInfo;

public interface OrderDetailInfoMapper {

	List<OrderDetailInfo> findOrderDetailInfos(@Param(value = "orderId") Long orderId);

}
