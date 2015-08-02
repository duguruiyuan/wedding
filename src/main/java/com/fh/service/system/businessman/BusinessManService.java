package com.fh.service.system.businessman;

import java.util.List;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;

@Service("businessManService")
@Transactional
public class BusinessManService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	private static final DozerBeanMapper MAPPER = new DozerBeanMapper();
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 查找所有商户
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 */
	public List<PageData> listAllBusinessMan(Page page) throws Exception {
		return (List<PageData>) dao.findForList("BusinessManMapper.listAllBusinessMan", page);
	}
}
