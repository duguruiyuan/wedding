package com.fh.service.system.businessman;

import java.util.List;

import javax.annotation.Resource;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.dao.BusinessManInfoMapper;
import com.fh.dao.DaoSupport;
import com.fh.entity.BmiRequest;
import com.fh.entity.BusinessManInfo;
import com.fh.entity.MybatisPageable;
import com.fh.entity.Page;
import com.fh.util.PageData;
import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.BusinessManDetailReq;
import com.fh.vo.response.BusinessManDetailResp;
import com.fh.vo.response.BusinessManListResp;

/**
 * 商户Service
 * 
 * @author wujinsong
 *
 */
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
	@SuppressWarnings("unchecked")
	public List<PageData> listAllBusinessMan(Page page) throws Exception {
		return (List<PageData>) dao.findForList("BusinessManMapper.listAllBusinessMan", page);
	}

	@Autowired
	private BusinessManInfoMapper businessManInfoMapper;

	public ResponseBody businessManList(RequestBody requestBody) {
		BmiRequest bmiRequest = new BmiRequest();
		MAPPER.map(requestBody, bmiRequest);
		List<BusinessManInfo> businessManInfos = businessManInfoMapper.findBusinessManInfos(bmiRequest,
				new MybatisPageable(Integer.valueOf(bmiRequest.getPageSize()),
						Integer.valueOf(bmiRequest.getPageNo())));
		BusinessManListResp businessManListResp = new BusinessManListResp();
		businessManListResp.setBusinessManInfos(businessManInfos);
		return businessManListResp;

	}

	public ResponseBody businessManDetail(RequestBody requestBody) {

		BusinessManDetailReq detailReq = (BusinessManDetailReq) requestBody;
		BusinessManInfo businessManInfo = businessManInfoMapper.findBusinessManInfo(detailReq.getId());
		BusinessManDetailResp businessManDetailResp = new BusinessManDetailResp();
		businessManDetailResp.setBusinessManInfo(businessManInfo);
		return businessManDetailResp;

	}

	/**
	 * 根据id获取商户
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 * @author wujinsong
	 */
	public PageData findById(PageData pd) throws Exception {
		return (PageData) dao.findForObject("BusinessManMapper.findById", pd);
	}

	/**
	 * 新增商户
	 * 
	 * @param pd
	 * @throws Exception
	 * @author wujinsong
	 */
	public void saveBusinessMan(PageData pd) throws Exception {
		dao.update("BusinessManMapper.saveBusinessMan", pd);
	}

	/**
	 * 修改商户
	 * 
	 * @param pd
	 * @throws Exception
	 * @author wujinsong
	 */
	public void editBusinessMan(PageData pd) throws Exception {
		dao.update("BusinessManMapper.updateById", pd);
	}

	/**
	 * 删除商户
	 * 
	 * @param pd
	 * @throws Exception
	 * @author wujinsong
	 */
	public void deleteBusinessMan(PageData pd) throws Exception {
		dao.delete("BusinessManMapper.deleteBusinessMan", pd);
	}

	/**
	 * 批量删除商户
	 * 
	 * @param BUSINESSMAN_IDS
	 * @throws Exception
	 * @author wujinsong
	 */
	public void deleteAllBusinessMans(String[] BUSINESSMAN_IDS) throws Exception {
		dao.delete("BusinessManMapper.deleteAllBusinessMans", BUSINESSMAN_IDS);
	}

	/**
	 * 商户列表(分页)
	 * 
	 * @param pd
	 * @return
	 * @throws Exception
	 * @author wujinsong
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> businessManListPage(Page pd) throws Exception {
		logger.info("获取商户列表");
		return (List<PageData>) dao.findForList("BusinessManMapper.businessManListPage", pd);
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
	public List<PageData> listAllBusinessMans(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("BusinessManMapper.listAllBusinessMans", pd);
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
			return (PageData) dao.findForObject("BusinessManMapper.findById", pd);
		} catch (Exception e) {

		}

		return null;
	}
}
