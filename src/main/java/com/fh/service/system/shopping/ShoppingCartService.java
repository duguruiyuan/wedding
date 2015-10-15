package com.fh.service.system.shopping;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.dao.DaoSupport;
import com.fh.dao.ShoppingCartInfoMapper;
import com.fh.dao.ShoppingCartMapper;
import com.fh.entity.MybatisPageable;
import com.fh.entity.Page;
import com.fh.entity.ShoppingCart;
import com.fh.entity.ShoppingCartInfo;
import com.fh.util.PageData;
import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.ShoppingCartListReq;
import com.fh.vo.request.ShoppingReq;
import com.fh.vo.response.ShoppingCartListResp;

@Service
@Transactional
public class ShoppingCartService {
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@Autowired
	private ShoppingCartInfoMapper shoppingCartInfoMapper;
	@Autowired
	private ShoppingCartMapper shoppingCartMapper;

	public ResponseBody shoppingCartList(RequestBody requestBody, Long id) {
		ShoppingCartListReq shoppingCartListReq = (ShoppingCartListReq) requestBody;
		List<ShoppingCartInfo> shoppingCartInfos = shoppingCartInfoMapper.findShoppingCartInfos(id, new MybatisPageable(
				Integer.valueOf(shoppingCartListReq.getPageSize()), Integer.valueOf(shoppingCartListReq.getPageNo())));
		ShoppingCartListResp shoppingCartListResp = new ShoppingCartListResp();
		shoppingCartListResp.setShoppingCartList(shoppingCartInfos);
		return shoppingCartListResp;

	}

	public ResponseBody shopping(RequestBody requestBody, Long id) {
		ShoppingReq shoppingReq = (ShoppingReq) requestBody;

		ShoppingCart shoppingCart = shoppingCartMapper.selectByProductId(shoppingReq.getProductId(), id);

		if (null == shoppingCart) {
			shoppingCart = new ShoppingCart();
			shoppingCart.setCount(shoppingReq.getCount());
			shoppingCart.setProductId(shoppingReq.getProductId());
			shoppingCart.setUserId(id);
			shoppingCartMapper.insert(shoppingCart);

		} else {
			shoppingCart.setCount(shoppingCart.getCount() + shoppingReq.getCount());
			shoppingCartMapper.updateByPrimaryKey(shoppingCart);
		}
		return ResponseBody.createResponseBody("");

	}

	/**
	 * 购物车列表(分页)
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 * @author wujinsong
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> shoppingCartlistPage(Page pd) throws Exception {
		logger.info("获取购物车列表");
		return (List<PageData>) dao.findForList("com.fh.dao.ShoppingCartMapper.shoppingCartlistPage", pd);
	}

	/**
	 * 获取所有的购物车
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 * @author wujinsong
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAllShoppingCarts(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("com.fh.dao.ShoppingCartMapper.listAllShoppingCarts", pd);
	}
}
