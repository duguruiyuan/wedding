package com.fh.controller.system.businessman;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fh.constants.Constants;
import com.fh.controller.base.BaseController;
import com.fh.dao.DictionaryMapper;
import com.fh.entity.Dictionary;
import com.fh.entity.Page;
import com.fh.entity.system.Role;
import com.fh.service.system.businessman.BusinessManService;
import com.fh.service.system.dictionaries.DictionariesService;
import com.fh.service.system.role.RoleService;
import com.fh.util.AppUtil;
import com.fh.util.Const;
import com.fh.util.Jurisdiction;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;

/**
 * 商户Controller
 * 
 * @author wujinsong
 *
 */
@Controller
@RequestMapping(value = "/businessMan")
public class BusinessManController extends BaseController {
	// 菜单地址(权限用)
	String menuUrl = "businessMan/listBusinessMan.do";
	@Resource(name = "businessManService")
	private BusinessManService businessManService;
	@Resource(name = "roleService")
	private RoleService roleService;
	@Resource(name = "dictionariesService")
	private DictionariesService dictionariesService;
	@Autowired
	private DictionaryMapper dictionaryMapper;

	/**
	 * 保存商户
	 * 
	 * @param out
	 * @return
	 * @throws Exception
	 * @author wujinsong
	 */
	@RequestMapping(value = "/saveBusinessMan")
	public ModelAndView saveBusinessMan(PrintWriter out) throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			pd.put("created_date", new Date());
			businessManService.saveBusinessMan(pd);
			mv.addObject("msg", "success");
		} catch (Exception e) {
			mv.addObject("msg", "failed");
		}

		mv.setViewName("save_result");
		return mv;
	}

	/**
	 * 修改商户
	 * 
	 * @param out
	 * @return
	 * @throws Exception
	 * @author wujinsong
	 */
	@RequestMapping(value = "/editBusinessMan")
	public ModelAndView editBusinessMan(PrintWriter out) throws Exception {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();

		if (Jurisdiction.buttonJurisdiction(menuUrl, "edit")) {
			businessManService.editBusinessMan(pd);
		}
		mv.addObject("msg", "success");
		mv.setViewName("save_result");

		return mv;
	}

	/**
	 * 去修改商户页面
	 * 
	 * @return
	 * @author wujinsong
	 */
	@RequestMapping(value = "/goEditBusinessMan")
	public ModelAndView goEditBusinessMan() {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			// 列出所有二级角色
			List<Role> roleList = roleService.listAllappERRoles();
			// 根据ID读取
			pd = businessManService.selectByPrimaryKey(pd);
			mv.setViewName("system/businessman/businessman_edit");
			mv.addObject("msg", "editBusinessMan");
			mv.addObject("pd", pd);
			mv.addObject("roleList", roleList);
			
			List<Dictionary> businessManTypes = dictionaryMapper.findByPBM(Constants.SJLB);
			mv.addObject("businessManTypes", businessManTypes);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return mv;
	}

	/**
	 * 去新增商户页面
	 * 
	 * @return
	 * @author wujinsong
	 */
	@RequestMapping(value = "/goAddBusinessMan")
	public ModelAndView goAddBusinessMan() {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			List<Role> roleList;
			// 列出所有二级角色
			roleList = roleService.listAllappERRoles(); 
			mv.setViewName("system/businessman/businessman_edit");
			mv.addObject("msg", "saveBusinessMan");
			mv.addObject("pd", pd);
			mv.addObject("roleList", roleList);
			
			List<Dictionary> businessManTypes = dictionaryMapper.findByPBM(Constants.SJLB);
			mv.addObject("businessManTypes", businessManTypes);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return mv;
	}

	/**
	 * 现实商户列表
	 * 
	 * @param page
	 * @return
	 * @author wujinsong
	 */
	@RequestMapping(value = "/listBusinessMan")
	public ModelAndView listUsers(Page page) {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try {
			pd = this.getPageData();

			String name = pd.getString("name");

			if (null != name && !"".equals(name)) {
				name = name.trim();
				pd.put("name", name);
			}

			String STATUS = pd.getString("STATUS");

			if (null != STATUS && !"".equals(STATUS)) {
				STATUS = STATUS.trim();
				pd.put("STATUS", STATUS);
			}

			page.setPd(pd);
			// 列出商户列表
			List<PageData> businessManList = businessManService.businessManListPage(page);
			// 列出所有会员二级角色
			List<Role> roleList = roleService.listAllappERRoles();

			List<Dictionary> businessManTypes = dictionaryMapper.findByPBM(Constants.SJLB);
			mv.addObject("businessManTypes", businessManTypes);

			mv.setViewName("system/businessman/businessman_list");
			mv.addObject("businessManList", businessManList);
			mv.addObject("roleList", roleList);
			mv.addObject("pd", pd);
			// 按钮权限
			mv.addObject(Const.SESSION_QX, this.getHC()); 
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}

		return mv;
	}

	/**
	 * 删除商户
	 * 
	 * @param out
	 * @author wujinsong
	 */
	@RequestMapping(value = "/deleteBusinessMan")
	public void deleteBusinessMan(PrintWriter out) {
		PageData pd = new PageData();
		try {
			pd = this.getPageData();
			if (Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
				businessManService.deleteBusinessMan(pd);
			}
			out.write("success");
			out.close();
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}

	}

	/**
	 * 批量删除商户
	 * 
	 * @return
	 * @author wujinsong
	 */
	@RequestMapping(value = "/deleteAllBusinessMans")
	@ResponseBody
	public Object deleteAllBusinessMans() {
		PageData pd = new PageData();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			pd = this.getPageData();
			List<PageData> pdList = new ArrayList<PageData>();
			String USER_IDS = pd.getString("USER_IDS");

			if (null != USER_IDS && !"".equals(USER_IDS)) {
				String ArrayUSER_IDS[] = USER_IDS.split(",");
				if (Jurisdiction.buttonJurisdiction(menuUrl, "del")) {
					businessManService.deleteAllBusinessMans(ArrayUSER_IDS);
				}
				pd.put("msg", "ok");
			} else {
				pd.put("msg", "no");
			}

			pdList.add(pd);
			map.put("list", pdList);
		} catch (Exception e) {
			logger.error(e.toString(), e);
		} finally {
			logAfter(logger);
		}
		return AppUtil.returnObject(pd, map);
	}

	/*
	 * 导出产品信息到excel
	 * 
	 * @return
	 */
	@RequestMapping(value = "/excel")
	public ModelAndView exportExcel() {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		try {
			if (Jurisdiction.buttonJurisdiction(menuUrl, "cha")) {
				// 检索条件===
				String USERNAME = pd.getString("USERNAME");
				if (null != USERNAME && !"".equals(USERNAME)) {
					USERNAME = USERNAME.trim();
					pd.put("USERNAME", USERNAME);
				}
				String PRODUCTNAME = pd.getString("PRODUCTNAME");
				if (null != PRODUCTNAME && !"".equals(PRODUCTNAME)) {
					PRODUCTNAME = PRODUCTNAME.trim();
					pd.put("PRODUCTNAME", PRODUCTNAME);
				}
				String STATUS = pd.getString("STATUS");
				if (null != STATUS && !"".equals(STATUS)) {
					STATUS = STATUS.trim();
					pd.put("STATUS", STATUS);
				}
				String lastLoginStart = pd.getString("lastLoginStart");
				String lastLoginEnd = pd.getString("lastLoginEnd");
				if (lastLoginStart != null && !"".equals(lastLoginStart)) {
					lastLoginStart = lastLoginStart + " 00:00:00";
					pd.put("lastLoginStart", lastLoginStart);
				}
				if (lastLoginEnd != null && !"".equals(lastLoginEnd)) {
					lastLoginEnd = lastLoginEnd + " 00:00:00";
					pd.put("lastLoginEnd", lastLoginEnd);
				}
				// 检索条件===

				Map<String, Object> dataMap = new HashMap<String, Object>();
				List<String> titles = new ArrayList<String>();

				titles.add("订单编号"); // 1
				titles.add("购买用户"); // 2
				titles.add("产品名称"); // 3
				titles.add("状态"); // 4
				titles.add("价格"); // 5
				titles.add("创建日期"); // 6

				dataMap.put("titles", titles);

				List<PageData> userList = businessManService.listAllBusinessMans(pd);
				List<PageData> varList = new ArrayList<PageData>();
				for (int i = 0; i < userList.size(); i++) {
					PageData vpd = new PageData();
					vpd.put("var1", String.valueOf(userList.get(i).getLong("id"))); // 1
					vpd.put("var2", userList.get(i).getString("username")); // 2
					vpd.put("var3", userList.get(i).getString("name")); // 3
					vpd.put("var4", userList.get(i).getString("status")); // 4
					vpd.put("var5", String.valueOf(userList.get(i).getBigDecimal("price"))); // 5
					vpd.put("var6", String.valueOf(userList.get(i).get("created_date"))); // 6

					varList.add(vpd);
				}

				dataMap.put("varList", varList);

				ObjectExcelView erv = new ObjectExcelView();
				mv = new ModelAndView(erv, dataMap);
			}
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
		return mv;
	}

	// ===================================================================================================

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}

	/* ===============================权限================================== */
	@SuppressWarnings("unchecked")
	public Map<String, String> getHC() {
		Subject currentUser = SecurityUtils.getSubject(); // shiro管理的session
		Session session = currentUser.getSession();
		return (Map<String, String>) session.getAttribute(Const.SESSION_QX);
	}
	/* ===============================权限================================== */
}
