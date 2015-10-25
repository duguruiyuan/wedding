package com.fh.service.system.product;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.dao.DaoSupport;
import com.fh.dao.ProductInfoMapper;
import com.fh.entity.BmiRequest;
import com.fh.entity.MybatisPageable;
import com.fh.entity.Page;
import com.fh.entity.ProductInfo;
import com.fh.entity.system.User;
import com.fh.util.Const;
import com.fh.util.PageData;
import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.ProductDetailReq;
import com.fh.vo.response.ProductDetailResp;
import com.fh.vo.response.ProductListResp;

/**
 * 产品service
 * 
 * @author wujinsong
 *
 */
@Service("productService")
@Transactional
public class ProductService {

	@Autowired
	private ProductInfoMapper productInfoMapper;

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private static final DozerBeanMapper MAPPER = new DozerBeanMapper();

	public ResponseBody productList(RequestBody requestBody) {
		BmiRequest bmiRequest = new BmiRequest();
		MAPPER.map(requestBody, bmiRequest);
		List<ProductInfo> productInfos = productInfoMapper.findProductInfos(bmiRequest, new MybatisPageable(
				Integer.valueOf(bmiRequest.getPageSize()), Integer.valueOf(bmiRequest.getPageNo())));
		ProductListResp productListResp = new ProductListResp();
		productListResp.setProductInfos(productInfos);
		return productListResp;

	}

	public ResponseBody productDetail(RequestBody requestBody) {

		ProductDetailReq detailReq = (ProductDetailReq) requestBody;
		ProductInfo productInfo = productInfoMapper.findProductInfo(detailReq.getId());
		ProductDetailResp productDetailResp = new ProductDetailResp();
		productDetailResp.setProductInfo(productInfo);
		return productDetailResp;

	}

	/**
	 * 根据id获取产品
	 * 
	 * @param pd
	 * @throws Exception
	 * @author wujinsong
	 */
	public PageData findById(PageData pd) throws Exception {
		return (PageData) dao.findForObject("com.fh.dao.ProductMapper.ProductMapper.findById", pd);
	}

	/**
	 * 新增产品
	 * 
	 * @param pd
	 * @throws Exception
	 * @author wujinsong
	 */
	public void saveProduct(PageData pd) throws Exception {
		Subject currentUser = SecurityUtils.getSubject();  
		Session session = currentUser.getSession();
		
		User user = (User)session.getAttribute(Const.SESSION_USER);
		pd.put("user_id", user.getUSER_ID());
		dao.update("com.fh.dao.ProductMapper.saveProduct", pd);
	}

	/**
	 * 修改产品
	 * 
	 * @param pd
	 * @throws Exception
	 * @author wujinsong
	 */
	public void editProduct(PageData pd) throws Exception {
		dao.update("com.fh.dao.ProductMapper.updateById", pd);
	}

	/**
	 * 删除产品
	 * 
	 * @param pd
	 * @throws Exception
	 * @author wujinsong
	 */
	public void deleteProduct(PageData pd) throws Exception {
		dao.delete("ProductMapper.deleteProduct", pd);
	}

	/**
	 * 批量删除产品
	 * 
	 * @param ORDER_IDS
	 * @throws Exception
	 * @author wujinsong
	 */
	public void deleteAllProducts(String[] ORDER_IDS) throws Exception {
		dao.delete("ProductMapper.deleteAllProducts", ORDER_IDS);
	}

	/**
	 * 产品列表(分页)
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 * @author wujinsong
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> productlistPage(Page pd) throws Exception {
		logger.info("获取产品列表");
		return (List<PageData>) dao.findForList("com.fh.dao.ProductMapper.productlistPage", pd);
	}

	/**
	 * 获取所有产品
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 * @author wujinsong
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAllProducts(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("ProductMapper.listAllProducts", pd);
	}

	/**
	 * 根据主键查找
	 * 
	 * @param id
	 * @return
	 * @author wujinsong
	 */
	public PageData selectByPrimaryKey(PageData pd) {
		try {
			return (PageData) dao.findForObject("com.fh.dao.ProductMapper.findById", pd);
		} catch (Exception e) {

		}

		return null;
	}
}
