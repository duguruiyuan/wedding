package com.fh.service.system.appuser;

import java.util.List;

import javax.annotation.Resource;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.fh.dao.AppUserMapper;
import com.fh.dao.DaoSupport;
import com.fh.entity.AppUser;
import com.fh.entity.Page;
import com.fh.util.PageData;
import com.fh.util.UuidUtil;

@Service("appuserService")
@Transactional
public class AppuserService {

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	@Autowired
	private AppUserMapper appUserMapper;

	private static final DozerBeanMapper mapper = new DozerBeanMapper();

	private final Logger logger = LoggerFactory.getLogger(getClass());

	// ======================================================================================

	/*
	 * 通过id获取数据
	 */
	public PageData findByUiId(PageData pd) throws Exception {
		return (PageData) dao.findForObject("AppuserMapper.findByUiId", pd);
	}

	/*
	 * 通过loginname获取数据
	 */
	public PageData findByUId(PageData pd) throws Exception {
		return (PageData) dao.findForObject("AppuserMapper.findByUId", pd);
	}

	/*
	 * 通过邮箱获取数据
	 */
	public PageData findByUE(PageData pd) throws Exception {
		return (PageData) dao.findForObject("AppuserMapper.findByUE", pd);
	}

	/*
	 * 通过编号获取数据
	 */
	public PageData findByUN(PageData pd) throws Exception {
		return (PageData) dao.findForObject("AppuserMapper.findByUN", pd);
	}

	/*
	 * 保存用户
	 */
	public void saveU(PageData pd) throws Exception {
		dao.save("AppuserMapper.saveU", pd);
	}

	/*
	 * 修改用户
	 */
	public void editU(PageData pd) throws Exception {
		dao.update("AppuserMapper.editU", pd);
	}

	/*
	 * 删除用户
	 */
	public void deleteU(PageData pd) throws Exception {
		dao.delete("AppuserMapper.deleteU", pd);
	}

	/*
	 * 批量删除用户
	 */
	public void deleteAllU(String[] USER_IDS) throws Exception {
		dao.delete("AppuserMapper.deleteAllU", USER_IDS);
	}

	/*
	 * 用户列表(全部)
	 */
	public List<PageData> listAllUser(PageData pd) throws Exception {
		return (List<PageData>) dao
				.findForList("AppuserMapper.listAllUser", pd);
	}

	/*
	 * 用户列表(用户组)
	 */
	public List<PageData> listPdPageUser(Page page) throws Exception {
		return (List<PageData>) dao.findForList("AppuserMapper.userlistPage",
				page);
	}

	/*
	 * 保存用户IP
	 */
	public void saveIP(PageData pd) throws Exception {
		dao.update("AppuserMapper.saveIP", pd);
	}

	/*
	 * 登录判断
	 */
	public PageData getUserByNameAndPwd(PageData pd) throws Exception {
		return (PageData) dao.findForObject("AppuserMapper.getUserInfo", pd);
	}

	/*
	 * 跟新登录时间
	 */
	public void updateLastLogin(PageData pd) throws Exception {
		dao.update("AppuserMapper.updateLastLogin", pd);
	}

	// ======================================================================================

	public String createNickname() {
		String name = UuidUtil.get10UUID();
		if (appUserMapper.countByName(name) > 0)
			return createNickname();
		return name;
	}

	public void uploadImage(Long id, String imageUrl) {
		AppUser user = appUserMapper.selectByPrimaryKey(id);
		user.setImageUrl(imageUrl);
		appUserMapper.updateByPrimaryKey(user);
	}

	public boolean validateUser(AppUser user) {
		return (null != user);
	}

	public boolean validatePwd(AppUser user, String password) {
		return password.equals(user.getPassword());
	}
}
