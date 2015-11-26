package com.fh.controller.app.appuser;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.util.PageData;
import com.fh.service.system.interfaces.InterfacesService;

/**
 * 
 * @author jswul
 *
 */
@Controller
@RequestMapping(value = "/appinterface")
public class AppInterfaceController extends BaseController {

	@Resource(name = "interfacesService")
	private InterfacesService interfacesService;

	/**
	 * 新增行为记录
	 */
	@RequestMapping(value = "/list")
	public ModelAndView list() throws Exception {
		ModelAndView mv = this.getModelAndView();
		try {
			PageData pd = new PageData();
			pd = this.getPageData();
			List<PageData>	interfaces = interfacesService.listAll(pd);
			mv.addObject("interfaces", interfaces);
			mv.setViewName("/interfaces");
		} catch (Exception e) {
		}

		return mv;
	}
}
