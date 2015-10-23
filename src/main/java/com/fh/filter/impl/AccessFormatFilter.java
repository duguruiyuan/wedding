package com.fh.filter.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.fh.constants.AppConstants;
import com.fh.filter.AppFilter;
import com.fh.filter.AppFilterChain;
import com.fh.filter.IYiMingSession;
import com.fh.util.BusinessException;
import com.fh.util.MapUtil;
import com.fh.util.PropertiesReader;
import com.fh.vo.RequestBody;
import com.fh.vo.request.OrderReq;
import com.fh.vo.request.OrderReq.OrderDetail;
import com.google.gson.Gson;

/**
 * 
 * @author sm
 * 
 */
@Service
public class AccessFormatFilter implements AppFilter {

	private static Gson gson = new Gson();

	@Override
	public void doFilter(RequestBody requestBody,
			HttpServletRequest httpServletRequest, AppFilterChain appFilterChain) {
		RequestBody newBody;
		try {
			@SuppressWarnings("unchecked")
			Map<String, String[]> paramtersOld = httpServletRequest
					.getParameterMap();
			Map<String, String[]> paramters = new HashMap<String, String[]>();
			for (String key : paramtersOld.keySet()) {
				String[] param = paramtersOld.get(key);
				if (param[0].length() > 0) {
					paramters.put(key, param);
				}
			}
			// 参数map转化为bean
			newBody = (RequestBody) MapUtil
					.convertMap(
							AppConstants.APP_VO.get(requestBody.getMethod()),
							paramters);
			if (newBody instanceof OrderReq) {
				OrderReq req = (OrderReq) newBody;
				req.setOrderList(jsonToList(req.getOrderLists()));
			}
			IYiMingSession.put("requestBody", newBody);
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new BusinessException(AppConstants.CODE_115,
					PropertiesReader.readAsString(AppConstants.CODE_115));
		}
		appFilterChain.doFilter(newBody, httpServletRequest);
	}

	/**
	 * 
	 * @Author zy
	 * @Company:
	 * @Create Time: 2015年9月24日 下午5:10:02
	 * @param json
	 * @return
	 */
	private List<OrderDetail> jsonToList(String json) {
		List<OrderDetail> objList = null;
		if (gson != null) {
			java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<OrderDetail>>() {
			}.getType();
			objList = gson.fromJson(json, type);
		}
		return objList;
	}
}
