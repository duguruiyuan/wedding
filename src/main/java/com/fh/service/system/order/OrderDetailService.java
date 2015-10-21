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
 * 订单明细Service
 * 
 * @author wujinsong
 *
 */
@Service("orderDetailService")
@Transactional
public class OrderDetailService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 根据id获取订单明细
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 * @author wujinsong
	 */
	public PageData findById(PageData pd) throws Exception {
		return (PageData) dao.findForObject("OrderDetailMapper.findById", pd);
	}

	/**
	 * 新增订单明细
	 * 
	 * @param pd
	 * @throws Exception
	 * @author wujinsong
	 */
	public void saveOrderDetail(PageData pd) throws Exception {
		dao.update("OrderDetailMapper.saveOrder", pd);
	}

	/**
	 * 保存订单明细
	 * 
	 * @param pd
	 * @throws Exception
	 * @author wujinsong
	 */
	public void editOrderDetail(PageData pd) throws Exception {
		dao.update("OrderMapper.editOrderDetail", pd);
	}

	/**
	 * 删除订单
	 * 
	 * @param pd
	 * @throws Exception
	 * @author wujinsong
	 */
	public void deleteOrderDetail(PageData pd) throws Exception {
		dao.delete("OrderMapper.deleteOrderDetail", pd);
	}

	/**
	 * 批量删除订单明细
	 * 
	 * @param ORDER_DETAIL_IDS
	 * @throws Exception
	 * @author wujinsong
	 */
	public void deleteAllOrderDetails(String[] ORDER_DETAIL_IDS) throws Exception {
		dao.delete("OrderMapper.deleteAllOrderDetails", ORDER_DETAIL_IDS);
	}

	/**
	 * 订单明细(分页)
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 * @author wujinsong
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> orderDetailListPage(Page pd) throws Exception {
		logger.info("获取订单明细列表");
		return (List<PageData>) dao.findForList("OrderDetailMapper.orderDetailListPage", pd);
	}

	/**
	 * 获取所有订单明细
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 * @author wujinsong
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAllOrderDetails(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("OrderMapper.listAllOrderDetails", pd);
	}
}
