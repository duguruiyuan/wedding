package com.fh.dao;

import com.fh.entity.ShoppingCart;

public interface ShoppingCartMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
    
    ShoppingCart selectByProductId(Long productId,Long userId);
}