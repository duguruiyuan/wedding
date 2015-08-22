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
import com.fh.dao.BusinessManMapper;
import com.fh.dao.DaoSupport;
import com.fh.entity.BmiRequest;
import com.fh.entity.BusinessManInfo;
import com.fh.entity.MybatisPageable;
import com.fh.entity.Page;
import com.fh.util.PageData;
import com.fh.vo.RequestBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.BusinessManDetailReq;
import com.fh.vo.request.BusinessManListReq;
import com.fh.vo.response.BusinessManDetailResp;
import com.fh.vo.response.BusinessManListResp;

@Service("businessManService")
@Transactional
public class BusinessManService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	@Autowired
	private BusinessManMapper businessManMapper;

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
		return (List<PageData>) dao.findForList(
				"BusinessManMapper.listAllBusinessMan", page);
	}

	@Autowired
	private BusinessManInfoMapper businessManInfoMapper;

	public ResponseBody businessManList(RequestBody requestBody) {
		BmiRequest bmiRequest = new BmiRequest();
		MAPPER.map(requestBody, bmiRequest);
		List<BusinessManInfo> businessManInfos = businessManInfoMapper
				.findBusinessManInfos(bmiRequest, new MybatisPageable(Integer.valueOf(bmiRequest.getPageSize()),Integer.valueOf(bmiRequest.getPageNo())));
		BusinessManListResp businessManListResp = new BusinessManListResp();
		businessManListResp.setBusinessManInfos(businessManInfos);
		return businessManListResp;

	}
	
	public ResponseBody businessManDetail(RequestBody requestBody) {
		
		BusinessManDetailReq detailReq  =(BusinessManDetailReq) requestBody;
		BusinessManInfo businessManInfo = businessManInfoMapper.findBusinessManInfo(detailReq.getId());
		BusinessManDetailResp businessManDetailResp = new BusinessManDetailResp();
		businessManDetailResp.setBusinessManInfo(businessManInfo);
		return businessManDetailResp;

	}
	
	
	
}
