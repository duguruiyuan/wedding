package com.fh.service.system.order;

import java.util.List;

import javax.annotation.Resource;
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

	/**
	 * 根据id获取订单详情
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
	 * 修改订单明细
	 * 
	 * @param pd
	 * @throws Exception
	 * @author wujinsong
	 */
	public void editU(PageData pd) throws Exception {
		dao.update("OrderDetailMapper.editOrder", pd);
	}

	/**
	 * 删除订单明细
	 * 
	 * @param pd
	 * @throws Exception
	 * @author wujinsong
	 */
	public void deleteU(PageData pd) throws Exception {
		dao.delete("OrderDetailMapper.deleteOrder", pd);
	}

	/**
	 * 批量删除订单明细
	 * 
	 * @param ORDER_IDS
	 * @throws Exception
	 * @author wujinsong
	 */
	public void deleteAllU(String[] ORDER_IDS) throws Exception {
		dao.delete("OrderDetailMapper.deleteAllOrders", ORDER_IDS);
	}

	/**
	 * 订单明细列表
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 * @author wujinsong
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listPdPageOrderDetail(Page page) throws Exception {
		return (List<PageData>) dao.findForList("OrderDetailMapper.orderDetailListPage", page);
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
		return (List<PageData>) dao.findForList("OrderDetailMapper.listAllOrderDetails", pd);
	}
}
