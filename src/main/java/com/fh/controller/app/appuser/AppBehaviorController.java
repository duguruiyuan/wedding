package com.fh.controller.app.appuser;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fh.constants.Result;
import com.fh.controller.base.BaseController;
import com.fh.util.PageData;
import com.fh.vo.BehaviorVo;
import com.fh.service.system.behavior.BehaviorService;

/**
 * 类名称：BehaviorController 创建人：FH 创建时间：2015-11-25
 */
@Controller
@RequestMapping(value = "/appbehavior")
public class AppBehaviorController extends BaseController {

	String menuUrl = "behavior/list.do"; // 菜单地址(权限用)
	@Resource(name = "behaviorService")
	private BehaviorService behaviorService;

	/**
	 * 新增行为记录
	 */
	@RequestMapping(value = "/addBehavior")
	public Result<String> save(BehaviorVo behaviorVo) throws Exception {
		logBefore(logger, "新增Behavior");
		Result<String> result = new Result<String>();

		try {
			PageData pd = new PageData();
			pd = this.getPageData();
			pd.put("BEHAVIOR_ID", this.get32UUID()); // 主键
			pd.put("TYPE", behaviorVo.getType());
			pd.put("RELATIONID", behaviorVo.getRelationId());
			pd.put("APPUSERID", behaviorVo.getAppUserId());
			behaviorService.save(pd);
		} catch (Exception e) {

		}

		return result;
	}
}
