package com.fh.service.system.behavior;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.fh.dao.DaoSupport;
import com.fh.entity.Page;
import com.fh.util.PageData;

@Service("behaviorService")
public class BehaviorService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;

	/*
	 * 新增
	 */
	public void save(PageData pd) throws Exception {
		dao.save("BehaviorMapper.save", pd);
	}

	/*
	 * 删除
	 */
	public void delete(PageData pd) throws Exception {
		dao.delete("BehaviorMapper.delete", pd);
	}

	/*
	 * 修改
	 */
	public void edit(PageData pd) throws Exception {
		dao.update("BehaviorMapper.edit", pd);
	}

	/*
	 * 列表
	 */
	public List<PageData> list(Page page) throws Exception {
		return (List<PageData>) dao.findForList("BehaviorMapper.datalistPage", page);
	}

	/**
	 * 浏览酒店
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PageData> browseHotelListPage(Page page) throws Exception {
		return (List<PageData>) dao.findForList("BehaviorMapper.browseHotelListPage", page);
	}

	/**
	 * 浏览套餐
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PageData> browsePackageListPage(Page page) throws Exception {
		return (List<PageData>) dao.findForList("BehaviorMapper.browsePackageListPage", page);
	}
	
	/**
	 * 酒店收藏
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PageData> hotelCollectionListPage(Page page) throws Exception {
		return (List<PageData>) dao.findForList("BehaviorMapper.hotelCollectionListPage", page);
	}

	/**
	 * 服务点赞
	 * 
	 * @param page
	 * @return
	 * @throws Exception
	 */
	public List<PageData> serviceZambiaListPage(Page page) throws Exception {
		return (List<PageData>) dao.findForList("BehaviorMapper.serviceZambiaListPage", page);
	}

	/*
	 * 列表(全部)
	 */
	public List<PageData> listAll(PageData pd) throws Exception {
		return (List<PageData>) dao.findForList("BehaviorMapper.listAll", pd);
	}

	/*
	 * 通过id获取数据
	 */
	public PageData findById(PageData pd) throws Exception {
		return (PageData) dao.findForObject("BehaviorMapper.findById", pd);
	}

	/*
	 * 批量删除
	 */
	public void deleteAll(String[] ArrayDATA_IDS) throws Exception {
		dao.delete("BehaviorMapper.deleteAll", ArrayDATA_IDS);
	}

}
