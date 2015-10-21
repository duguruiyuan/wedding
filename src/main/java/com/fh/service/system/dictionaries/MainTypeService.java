package com.fh.service.system.dictionaries;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.DozerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.dao.MainTypeMapper;
import com.fh.entity.MainType;
import com.fh.vo.RequestBody;
import com.fh.vo.request.MainTypeReq;
import com.fh.vo.response.MainTypeResp;
import com.fh.vo.response.MainTypeResp.MainTypeInfo;

@Service
@Transactional
public class MainTypeService {

	@Autowired
	MainTypeMapper mainTypeMapper;

	private static DozerBeanMapper beanMapper = new DozerBeanMapper();

	public MainTypeResp getMainTypeList(MainTypeReq requestBody) {
		MainTypeResp mainTypeResp = new MainTypeResp();
		mainTypeResp.setMainTypeInfos(getMainTypeInfos(requestBody));
		mainTypeResp.setMemo("000000");
		return mainTypeResp;

	}

	public List<MainTypeInfo> getMainTypeInfos(MainTypeReq requestBody) {
		//Long id = requestBody.getId() == null ? 0l : requestBody.getId();
		List<MainType> list = mainTypeMapper.findByIdAndLevel(requestBody.getId(),
				requestBody.getLevel());
		List<MainTypeInfo> list2 = new ArrayList<MainTypeResp.MainTypeInfo>();
		for (MainType mainType : list) {
			MainTypeInfo mainTypeInfo = new MainTypeInfo();
			beanMapper.map(mainType, mainTypeInfo);
			list2.add(mainTypeInfo);
		}
		return list2;

	}
}
