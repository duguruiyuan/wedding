package com.fh.service.system.order;

import java.util.List;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;

/**
 * 订单Service
 * 
 * @author wujinsong
 *
 */
@Service("orderService")
@Transactional
public class OrderService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 根据id获取订单
	 * 
	 * @param pd
	 * @throws Exception
	 * @author wujinsong
	 */
	public PageData findById(PageData pd) throws Exception {
		return (PageData) dao.findForObject("OrderMapper.findById", pd);
	}

	/**
	 * 新增订单
	 * 
	 * @param pd
	 * @throws Exception
	 * @author wujinsong
	 */
	public void saveOrder(PageData pd) throws Exception {
		dao.update("OrderMapper.saveOrder", pd);
	}

	/**
	 * 修改订单
	 * 
	 * @param pd
	 * @throws Exception
	 * @author wujinsong
	 */
	public void editOrder(PageData pd) throws Exception {
		dao.update("OrderMapper.editOrder", pd);
	}

	/**
	 * 删除订单
	 * 
	 * @param pd
	 * @throws Exception
	 * @author wujinsong
	 */
	public void deleteOrder(PageData pd) throws Exception {
		dao.delete("OrderMapper.deleteOrder", pd);
	}

	/**
	 * 批量删除订单
	 * 
	 * @param ORDER_IDS
	 * @throws Exception
	 * @author wujinsong
	 */
	public void deleteAllOrders(String[] ORDER_IDS) throws Exception {
		dao.delete("OrderMapper.deleteAllOrders", ORDER_IDS);
	}

	/**
	 * 订单列表(分页)
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 * @author wujinsong
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> orderlistPage(Page pd) throws Exception {
		logger.info("获取订单列表");
		return (List<PageData>) dao.findForList("OrderMapper.orderlistPage", pd);
	}

	/**
	 * 获取所有订单
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 * @author wujinsong
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAllOrders(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("OrderMapper.listAllOrders", pd);
	}
}
