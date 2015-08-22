package com.fh.service.system.product;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.dao.ProductInfoMapper;
import com.fh.entity.BmiRequest;
import com.fh.entity.MybatisPageable;
import com.fh.entity.ProductInfo;
import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.ProductDetailReq;
import com.fh.vo.response.ProductDetailResp;
import com.fh.vo.response.ProductListResp;

@Service("productService")
@Transactional
public class ProductService {

	@Autowired
	private ProductInfoMapper productInfoMapper;

	private static final DozerBeanMapper MAPPER = new DozerBeanMapper();

	public ResponseBody productList(RequestBody requestBody) {
		BmiRequest bmiRequest = new BmiRequest();
		MAPPER.map(requestBody, bmiRequest);
		List<ProductInfo> productInfos = productInfoMapper.findProductInfos(
				bmiRequest,
				new MybatisPageable(Integer.valueOf(bmiRequest.getPageSize()),
						Integer.valueOf(bmiRequest.getPageNo())));
		ProductListResp productListResp = new ProductListResp();
		productListResp.setProductInfos(productInfos);
		return productListResp;

	}

	public ResponseBody productDetail(RequestBody requestBody) {

		ProductDetailReq detailReq = (ProductDetailReq) requestBody;
		ProductInfo productInfo = productInfoMapper.findProductInfo(detailReq
				.getId());
		ProductDetailResp productDetailResp = new ProductDetailResp();
		productDetailResp.setProductInfo(productInfo);
		return productDetailResp;

	}

}
