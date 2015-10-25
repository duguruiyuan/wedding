package com.fh.service.system.dictionaries;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.dao.DictionaryMapper;
import com.fh.entity.MainTypeInfo;
import com.fh.vo.request.MainTypeReq;
import com.fh.vo.response.MainTypeResp;

@Service
@Transactional
public class MainTypeService {

	@Autowired
	DictionaryMapper mainTypeMapper;

	private static DozerBeanMapper beanMapper = new DozerBeanMapper();

	public MainTypeResp getMainTypeList(MainTypeReq requestBody) {
		MainTypeResp mainTypeResp = new MainTypeResp();
		mainTypeResp.setMainTypeInfos(getMainTypeInfos(requestBody));
		mainTypeResp.setMemo("000000");
		return mainTypeResp;

	}

	public List<MainTypeInfo> getMainTypeInfos(MainTypeReq requestBody) {
		// Long id = requestBody.getId() == null ? 0l : requestBody.getId();
		List<MainTypeInfo> list = mainTypeMapper.findByIdAndLevel(
				requestBody.getId(), requestBody.getLevel());

		return list;

	}
}
