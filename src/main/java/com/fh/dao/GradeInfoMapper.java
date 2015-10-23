package com.fh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fh.entity.Grade;
import com.fh.entity.GradeInfo;
import com.fh.entity.MybatisPageable;

public interface GradeInfoMapper {

	List<GradeInfo> findGradeInfos(@Param("productId") Long productId,
			@Param(value = "pageable") MybatisPageable pageable);

}