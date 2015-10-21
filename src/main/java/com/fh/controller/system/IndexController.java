package com.fh.controller.system;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.entity.system.Role;
import com.fh.service.system.businessman.BusinessManService;
import com.fh.service.system.product.ProductService;
import com.fh.service.system.role.RoleService;
import com.fh.util.Const;
import com.fh.util.PageData;

@Controller
@RequestMapping(value = "/index")
public class IndexController extends BaseController {
	@Autowired
	private BusinessManService businessManService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/listBusinessMan")
	public ModelAndView listUsers(Page page) {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try {
			pd = this.getPageData();

			pd.put("ding_flag", 1);
			page.setPd(pd);
			// 列出商户列表
			List<PageData> businessManList = businessManService.businessManListPage(page);
			// 列出所有会员二级角色
			List<Role> roleList = roleService.listAllappERRoles();

			mv.setViewName("system/index/businessman_list_index");
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

	@RequestMapping(value = "/listProduct")
	public ModelAndView listProduct(Page page) {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try {
			pd = this.getPageData();

			String type = pd.getString("type");
			if (type.equals("1")) {
				pd.put("recommend", 1);
			} else if (type.equals("2")) {
				pd.put("recommend", 0);
			}

			page.setPd(pd);
			List<PageData> productList = productService.productlistPage(page); // 列出用户列表
			List<Role> roleList = roleService.listAllappERRoles(); // 列出所有会员二级角色
			mv.addObject("productList", productList);
			mv.addObject("roleList", roleList);
			mv.setViewName("system/index/product_list_index");
			mv.addObject("pd", pd);
			mv.addObject(Const.SESSION_QX, this.getHC()); // 按钮权限
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
