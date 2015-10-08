package com.fh.service.system.appuser;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.fh.constants.AppConstants;
import com.fh.dao.AppUserMapper;
import com.fh.dao.DaoSupport;
import com.fh.entity.AppUser;
import com.fh.entity.Page;
import com.fh.service.system.file.FileService;
import com.fh.util.PageData;
import com.fh.util.UuidUtil;
import com.fh.vo.ErrorResponseBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.CompleteProfileReq;
import com.fh.vo.request.LoginReq;
import com.fh.vo.request.RegisterReq;
import com.fh.vo.request.ThirdRegisterReq;
import com.fh.vo.response.GetProfileResp;
import com.fh.vo.response.ThirdRegisterResp;

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

	public ResponseBody register(RegisterReq registerReq,
			HttpServletRequest httpServletRequest) {

		if (appUserMapper.countByUsername(registerReq.getUsername()) > 0)
			return ErrorResponseBody.createErrorResponseBody("用户名已存在");
		if (appUserMapper.countByMobile(registerReq.getPhone()) > 0)
			return ErrorResponseBody.createErrorResponseBody("手机号已被绑定");
		AppUser user = null;
		if (httpServletRequest.getSession().getAttribute(AppConstants.TEMP_ID) == null) {
			user = new AppUser();
			mapper.map(registerReq, user);
			user.setName(registerReq.getUsername());

			appUserMapper.insert(user);

			user = appUserMapper.findByUsername(user.getUsername());

		} else {
			Long userId = (Long) httpServletRequest.getSession().getAttribute(
					AppConstants.TEMP_ID);
			user = appUserMapper.selectByPrimaryKey(userId);
			mapper.map(registerReq, user);
			appUserMapper.updateByPrimaryKey(user);
			httpServletRequest.getSession().removeAttribute(
					AppConstants.TEMP_ID);

		}
		httpServletRequest.getSession().setAttribute(
				AppConstants.SESSION_USER_ID, user.getUserId());
		return ResponseBody.createResponseBody("保存用户成功");

	}

	public ResponseBody thirdRegister(ThirdRegisterReq registerReq,
			HttpServletRequest httpServletRequest) {
		PageData pageData = new PageData();
		pageData.put("sfid", registerReq.getSfid());
		pageData.put("thirdType", registerReq.getThirdType());
		AppUser appUser = appUserMapper.findByThirdTypeAndOpenId(pageData);
		if (null == appUser) {
			AppUser user = new AppUser();
			mapper.map(registerReq, user);
			user.setName(createNickname());
			ThirdRegisterResp registerResp = new ThirdRegisterResp();
			try {
				appUserMapper.insert(user);
				registerResp.setStatus(AppConstants.CODE_000);
				registerResp.setMemo("第三方尚未绑定手机");
				registerResp.setFlag("2");
				/*
				 * AppUser userInfo
				 * =appUserMapper.findByUsername(user.getUsername());
				 * httpServletRequest.getSession().setAttribute(
				 * AppConstants.SESSION_USER_ID, userInfo.getUserId());
				 */
				AppUser userInfo = appUserMapper.findByName(user.getName());
				httpServletRequest.getSession().setAttribute(
						AppConstants.TEMP_ID, userInfo.getUserId());
				return registerResp;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ErrorResponseBody.createErrorResponseBody("第三方注册失败");
			}
		} else if (!StringUtils.isEmpty(appUser.getUsername())) {
			ThirdRegisterResp registerResp = new ThirdRegisterResp();
			registerResp.setStatus(AppConstants.CODE_000);
			registerResp.setMemo("第三方用户登录成功");
			httpServletRequest.getSession().setAttribute(
					AppConstants.SESSION_USER_ID, appUser.getUserId());
			return registerResp;
		} else {
			ThirdRegisterResp registerResp = new ThirdRegisterResp();
			registerResp.setStatus(AppConstants.CODE_000);
			registerResp.setMemo("第三方尚未绑定手机");
			registerResp.setFlag("2");
			httpServletRequest.getSession().setAttribute(AppConstants.TEMP_ID,
					appUser.getUserId());
			return registerResp;
		}

	}

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

	/**
	 * 用户登录
	 * 
	 * @param loginReq
	 * @return
	 */
	public ResponseBody login(HttpServletRequest httpServletRequest,
			LoginReq loginReq) {

		AppUser user = appUserMapper.findByUsername(loginReq.getUsername());
		logger.info(loginReq.getUsername() + ":" + loginReq.getPassword());
		if (validateUser(user)) {
			if (validatePwd(user, loginReq.getPassword())) {
				httpServletRequest.getSession().setAttribute(
						AppConstants.SESSION_USER_ID, user.getUserId());
				return ResponseBody.createResponseBody("登陆成功");
			}
		}
		return ErrorResponseBody.createErrorResponseBody("密码错误");
	}

	public boolean validateUser(AppUser user) {
		return (null != user);
	}

	public boolean validatePwd(AppUser user, String password) {
		return password.equals(user.getPassword());
	}

	/**
	 * @author SM
	 * @description 退出
	 */
	public ResponseBody logout(HttpServletRequest httpServletRequest) {
		HttpSession httpSession = httpServletRequest.getSession();

		Iterator<String> iterator = CollectionUtils.toIterator(httpSession
				.getAttributeNames());
		while (iterator.hasNext()) {
			httpSession.removeAttribute(iterator.next());
		}
		httpSession.invalidate();
		return ResponseBody.createResponseBody("成功退出");

	}

	@Autowired
	private FileService fileService;

	public ResponseBody completeProfile(CompleteProfileReq completeProfileReq,
			Long id, HttpServletRequest httpServletRequest) {
		AppUser user = appUserMapper.selectByPrimaryKey(id);
		user.setName(completeProfileReq.getNickName());
		appUserMapper.updateByPrimaryKey(user);
		if (httpServletRequest instanceof MultipartHttpServletRequest)
			fileService
					.uploadAvatar((MultipartHttpServletRequest) httpServletRequest);
		return ResponseBody.createResponseBody("完善资料成功");

	}

	/**
	 * @author SM
	 * @description 修改密码
	 */
	public ResponseBody changePassword(HttpServletRequest httpServletRequest,
			String oldPassword, String newPassword, String newPassword2) {

		if (StringUtils.isEmpty(newPassword))
			return ErrorResponseBody.createErrorResponseBody("新密码不能为空");

		if (!newPassword.equals(newPassword2))
			return ErrorResponseBody.createErrorResponseBody("新密码和重复密码必须一致");

		AppUser user = appUserMapper
				.selectByPrimaryKey((Long) httpServletRequest.getSession()
						.getAttribute(AppConstants.SESSION_USER_ID));

		if (oldPassword.equals(user.getPassword())) {
			user.setPassword(newPassword);
			appUserMapper.updateByPrimaryKey(user);
			return ResponseBody.createResponseBody("修改密码成功");
		} else {
			return ErrorResponseBody.createErrorResponseBody("原密码不正确!");
		}

	}

	public ResponseBody getProfile(Long id, String contextPath) {
		AppUser user = appUserMapper.selectByPrimaryKey(id);
		GetProfileResp getProfileResp = new GetProfileResp();
		mapper.map(user, getProfileResp);
		getProfileResp.setStatus(AppConstants.CODE_000);
		getProfileResp.setImageUrl(contextPath + "/file/getAvatar/"+id);
		return getProfileResp;

	}

}
