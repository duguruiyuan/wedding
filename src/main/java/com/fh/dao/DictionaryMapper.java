package com.fh.dao;

import java.util.List;

import com.fh.entity.Dictionary;

/**
 * 字典mapper
 * 
 * @author wujinsong
 *
 */
public interface DictionaryMapper {
	/**
	 * 根据父编码查找字典
	 * 
	 * @param pBm
	 * @return
	 * @author wujinsong
	 */
	List<Dictionary> findByPBM(String pBm);
}
