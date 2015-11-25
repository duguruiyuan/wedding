package com.fh.controller.app.appuser;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.service.system.hotel.HotelService;
import com.fh.util.PageData;


/**
  * 会员-接口类 
  *    
  * 相关参数协议：
  * 00	请求失败
  * 01	请求成功
  * 02	返回空值
  * 03	请求协议参数不完整    
  * 04  用户名或密码错误
  * 05  FKEY验证失败
 */
@Controller
@RequestMapping(value="/apphotel")
public class AppHotelController extends BaseController {
	@Resource(name="hotelService")
	private HotelService hotelService;

	/**
	 * 酒店列表
	 * @return
	 */
	@RequestMapping(value="/listPage")
	@ResponseBody
	public List<PageData> listApi(Page page){
		logBefore(logger, "列表Hotel");
		PageData pd = new PageData();
		try{
			pd = this.getPageData();
			page.setPd(pd);
			//列出Hotel列表
			List<PageData>	varList = hotelService.list(page);
			
			return varList;
		} catch(Exception e){
		}
		return null;
	}
}
	
 