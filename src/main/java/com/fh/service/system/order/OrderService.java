package com.fh.service.system.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.dao.BusinessManMapper;
import com.fh.dao.DaoSupport;
import com.fh.dao.OrderDetailInfoMapper;
import com.fh.dao.OrderDetailMapper;
import com.fh.dao.OrderInfoMapper;
import com.fh.dao.OrderMapper;
import com.fh.dao.ProductMapper;
import com.fh.dao.ShoppingCartInfoMapper;
import com.fh.dao.ShoppingCartMapper;
import com.fh.entity.BmiRequest;
import com.fh.entity.BusinessMan;
import com.fh.entity.MybatisPageable;
import com.fh.entity.Order;
import com.fh.entity.OrderDetailInfo;
import com.fh.entity.OrderInfo;
import com.fh.entity.OrderPageRequest;
import com.fh.entity.Page;
import com.fh.entity.Product;
import com.fh.entity.ProductInfo;
import com.fh.entity.ShoppingCart;
import com.fh.util.PageData;
import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.OrderListReq;
import com.fh.vo.request.OrderReq;
import com.fh.vo.request.OrderReq.OrderDetail;
import com.fh.vo.response.OrderListResp;
import com.fh.vo.response.OrderResp;
import com.fh.vo.response.ProductListResp;

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

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private BusinessManMapper businessManMapper;

	@Autowired
	private OrderDetailMapper orderDetailMapper;

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	ShoppingCartMapper shoppingCartMapper;

	@Autowired
	OrderInfoMapper orderInfoMapper;

	@Autowired
	OrderDetailInfoMapper orderDetailInfoMapper;

	private static final DozerBeanMapper MAPPER = new DozerBeanMapper();

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public ResponseBody orderList(OrderListReq requestBody, Long userId) {
		OrderPageRequest bmiRequest = new OrderPageRequest();
		MAPPER.map(requestBody, bmiRequest);
		bmiRequest.setUserId(userId);
		OrderListResp orderListResp = new OrderListResp();
		List<OrderInfo> orderInfos = orderInfoMapper.findOrderInfos(bmiRequest,
				new MybatisPageable(Integer.valueOf(bmiRequest.getPageSize()),
						Integer.valueOf(bmiRequest.getPageNo())));
		for (OrderInfo orderInfo : orderInfos) {
			List<OrderDetailInfo> orderDetails = orderDetailInfoMapper
					.findOrderDetailInfos(orderInfo.getId());
			BigDecimal totalNoDealPrice = BigDecimal.ZERO;
			for (OrderDetailInfo orderDetailInfo : orderDetails) {
				totalNoDealPrice = totalNoDealPrice.add(orderDetailInfo.getPrice());
			}
			orderInfo.setTotalNoDealPrice(totalNoDealPrice);
			orderInfo.setOrderDetails(orderDetails);

		}
		orderListResp.setOrderInfos(orderInfos);
		orderListResp.setStatus("000000");
		return orderListResp;

	}

	public ResponseBody order(OrderReq orderReq, Long userId) {
		Map<Long, List<OrderDetail>> orderMap = new HashMap<Long, List<OrderDetail>>();
		for (OrderDetail orderDetail : orderReq.getOrderList()) {
			Product product = productMapper.selectByPrimaryKey(orderDetail
					.getProductId());
			BusinessMan businessMan = businessManMapper
					.selectByPrimaryKey(product.getUserId());
			List<OrderDetail> orderDetails = orderMap.get(businessMan
					.getUserId());
			if (CollectionUtils.isEmpty(orderDetails)) {
				orderDetails = new ArrayList<OrderReq.OrderDetail>();
			}
			orderDetails.add(orderDetail);
			orderMap.put(businessMan.getUserId(), orderDetails);
		}
		List<Long> orderIds = new ArrayList<Long>();
		for (Long id : orderMap.keySet()) {
			List<OrderDetail> details = orderMap.get(id);
			Order order = new Order();
			order.setFlowId("未付款");
			order.setCreatedDate(new Date());
			order.setUserId(userId);
			order.setBusinessManId(id);
			orderMapper.insert(order);
			for (OrderDetail detail : details) {
				com.fh.entity.OrderDetail detail2 = new com.fh.entity.OrderDetail();
				detail2.setCount(detail.getCount());
				if (detail.getShoppingCartId() != null) {
					shoppingCartMapper.deleteByPrimaryKey(detail
							.getShoppingCartId());
				}
				detail2.setFlowId("未付款");
				detail2.setProductId(detail.getProductId());
				detail2.setOrderId(order.getId());
				orderDetailMapper.insert(detail2);
			}
			orderIds.add(order.getId());
		}
		OrderResp orderResp = new OrderResp();
		orderResp.setStatus("000000");
		orderResp.setOrderIds(orderIds);
		return orderResp;

	}

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
		return (List<PageData>) dao
				.findForList("OrderMapper.orderlistPage", pd);
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
		return (List<PageData>) dao
				.findForList("OrderMapper.listAllOrders", pd);
	}

}
