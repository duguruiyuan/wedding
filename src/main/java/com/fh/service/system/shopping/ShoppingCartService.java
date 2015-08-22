package com.fh.service.system.shopping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.dao.ShoppingCartInfoMapper;
import com.fh.entity.MybatisPageable;
import com.fh.entity.ShoppingCartInfo;
import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.ShoppingCartListReq;
import com.fh.vo.response.ShoppingCartListResp;

@Service
@Transactional
public class ShoppingCartService {

	@Autowired
	private ShoppingCartInfoMapper shoppingCartInfoMapper;

	public ResponseBody shoppingCartList(RequestBody requestBody, Long id) {
		ShoppingCartListReq shoppingCartListReq = (ShoppingCartListReq) requestBody;
		List<ShoppingCartInfo> shoppingCartInfos = shoppingCartInfoMapper
				.findShoppingCartInfos(
						id,
						new MybatisPageable(Integer.valueOf(shoppingCartListReq
								.getPageSize()), Integer
								.valueOf(shoppingCartListReq.getPageNo())));
		ShoppingCartListResp shoppingCartListResp = new ShoppingCartListResp();
		shoppingCartListResp.setShoppingCartList(shoppingCartInfos);
		return shoppingCartListResp;

	}
}
