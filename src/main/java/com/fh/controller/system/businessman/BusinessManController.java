package com.fh.controller.system.businessman;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.service.system.businessman.BusinessManService;
import com.fh.util.PageData;

@Controller
@RequestMapping(value = "/businessMan")
public class BusinessManController extends BaseController {
	@Autowired
	private BusinessManService businessManService;

	@RequestMapping(value = "/listAllBusinessMan")
	public ModelAndView listAllBusinessMan(Page page) {
		ModelAndView mv = this.getModelAndView();

		PageData pd = new PageData();
		try {
			pd = this.getPageData();
			page.setPd(pd);
			List<PageData> businessManList = businessManService.listAllBusinessMan(page);

			mv.setViewName("system/businessman/businessman_list");
			mv.addObject("businessManList", businessManList);
			mv.addObject("pd", pd);
		} catch (Exception e) {
		}

		return mv;
	}
}
