package com.fh.controller.system.shoppingcart;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.springframework.web.servlet.ModelAndView;

import com.fh.constants.Constants;
import com.fh.controller.base.BaseController;
import com.fh.dao.DictionaryMapper;
import com.fh.entity.Dictionary;
import com.fh.entity.Page;
import com.fh.entity.system.Role;
import com.fh.service.system.dictionaries.DictionariesService;
import com.fh.service.system.role.RoleService;
import com.fh.service.system.shopping.ShoppingCartService;
import com.fh.util.Const;
import com.fh.util.PageData;

/**
 * 购物车Service
 * 
 * @author wujinsong
 *
 */
@Controller
@RequestMapping(value = "/shoppingCart")
public class ShoppingCartController extends BaseController {
	String menuUrl = "shoppingCart/listShoppingCart.do"; // 菜单地址(权限用)
	@Resource(name = "shoppingCartService")
	private ShoppingCartService shoppingCartService;
	@Resource(name = "roleService")
	private RoleService roleService;
	@Resource(name = "dictionariesService")
	private DictionariesService dictionariesService;
	@Autowired
	private DictionaryMapper dictionaryMapper;

	/**
	 * 显示购物车列表
	 */
	@RequestMapping(value = "/listShoppingCart")
	public ModelAndView listUsers(Page page) {
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		try {
			pd = this.getPageData();

			String username = pd.getString("username");

			if (null != username && !"".equals(username)) {
				username = username.trim();
				pd.put("USERNAME", username);
			}

			String status = pd.getString("status");

			if (null != status && !"".equals(status)) {
				status = status.trim();
				pd.put("status", status);
			}

			String productname = pd.getString("productname");

			if (null != productname && !"".equals(productname)) {
				productname = productname.trim();
				pd.put("PRODUCTNAME", productname);
			}

			page.setPd(pd);
			// 列出购物车列表
			List<PageData> shoppingCartList = shoppingCartService.shoppingCartlistPage(page);
			// 列出所有会员二级角色
			List<Role> roleList = roleService.listAllappERRoles();

			List<Dictionary> orderStates = dictionaryMapper.findByPBM(Constants.ORDER_STATE);
			mv.addObject("orderStates", orderStates);

			mv.setViewName("system/shoppingcart/shoppingcart_list");
			mv.addObject("shoppingCartList", shoppingCartList);
			mv.addObject("roleList", roleList);
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
