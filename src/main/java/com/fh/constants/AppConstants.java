package com.fh.constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.fh.service.handle.impl.ProductList;
import com.fh.vo.RequestBody;
import com.fh.vo.request.BusinessManDetailReq;
import com.fh.vo.request.BusinessManListReq;
import com.fh.vo.request.CompleteProfileReq;
import com.fh.vo.request.CreateVCReq;
import com.fh.vo.request.EditPwdReq;
import com.fh.vo.request.LoginReq;
import com.fh.vo.request.ProductDetailReq;
import com.fh.vo.request.ProductListReq;
import com.fh.vo.request.RegisterReq;
import com.fh.vo.request.ShoppingCartListReq;
import com.fh.vo.request.ThirdRegisterReq;
import com.google.gson.Gson;

public class AppConstants {
	
	public static final Gson GSON = new Gson();

	/**
	 * 有效
	 */
	public static final String VALID = "1";
	/**
	 * 无效
	 */
	public static final String INVALID = "9";

	/**
	 * APPSCRET
	 */
	public static final String APP_SCRET = "tuangou_guizhou";

	public static final String YMD = "yyyy-MM-dd";
	public static final String YMD_HMS = "yyyy-MM-dd HH:mm:ss";

	public static class DF {
		public static DateFormat DF1 = new SimpleDateFormat(YMD);
		public static DateFormat DF2 = new SimpleDateFormat(YMD_HMS);;
	}

	public static final String CODE_000 = "000";

	public static final String CODE_111 = "111";
	/* public static final String CODE_112 = "112"; */
	public static final String CODE_113 = "113";
	public static final String CODE_114 = "114";

	public static final String CODE_115 = "115";

	public static final String CODE_999 = "999";

	public static final String SESSION_ERROR_COUNT = "ERROR_COUNT";
	public static final String SESSION_CAP_TEXT = "CAP_TEXT";
	public static final String SESSION_USER_ID = "USER_ID";
	public static final String TEMP_ID = "TEMP_JJ";

	public static final String MESSAGE_VC = "验证码";

	/* 接口处理器 */
	public static final Map<String, String> APP_HANDLER = new HashMap<String, String>();

	public static final String LoginImpl = "login";
	public static final String EditPwd = "ep";
	public static final String CreateVC = "cvc";
	public static final String Register = "register";
	public static final String ThirdRegister = "thirdR";
	/* public static final String CreateCI = "cci"; */
	public static final String Logout = "logout";
	public static final String UploadAvatar = "ua";
	public static final String CompleteProfile = "cp";
	public static final String GetProfile = "gp";
	public static final String GetBusinessManList = "gbml";
	public static final String AtteOrCan = "aoc";
	public static final String FeedBack = "fb";
	public static final String GetVersion = "gv";
	public static final String GetBusinessManDetail = "gbmd";
	public static final String GetProductList = "gpl";
	public static final String GetProductDetail = "gpd";
	public static final String ShoppingCartList = "gscl";

	static {
		APP_HANDLER.put(LoginImpl, "login");
		APP_HANDLER.put(ThirdRegister, "thirdRegister");
		APP_HANDLER.put(EditPwd, "editPwd");
		APP_HANDLER.put(CreateVC, "createVC");
		APP_HANDLER.put(Register, "register");
		/* APP_HANDLER.put(CreateCI, "createCaptcha"); */
		APP_HANDLER.put(Logout, "logout");
		APP_HANDLER.put(UploadAvatar, "uploadAvatar");
		APP_HANDLER.put(CompleteProfile, "completeProfile");
		APP_HANDLER.put(GetProfile, "getProfile");
		APP_HANDLER.put(GetBusinessManList, "businessManList");
		APP_HANDLER.put(GetBusinessManDetail, "businessManDetail");
		APP_HANDLER.put(AtteOrCan, "attentionOrCancel");
		APP_HANDLER.put(FeedBack, "feedBack");
		APP_HANDLER.put(GetVersion, "getVersion");
		APP_HANDLER.put(GetProductList, "productList");
		APP_HANDLER.put(GetProductDetail, "productDetail");	
		APP_HANDLER.put(ShoppingCartList, "shoppingCartList");	
	}

	/* 接口处理器 */
	public static final Map<String, Class<? extends RequestBody>> APP_VO = new HashMap<String, Class<? extends RequestBody>>();
	static {
		APP_VO.put(Register, RegisterReq.class);
		APP_VO.put(ThirdRegister, ThirdRegisterReq.class);
		APP_VO.put(CreateVC, CreateVCReq.class);
		APP_VO.put(LoginImpl, LoginReq.class);
		APP_VO.put(Logout, RequestBody.class);
		APP_VO.put(EditPwd, EditPwdReq.class);
		APP_VO.put(CompleteProfile, CompleteProfileReq.class);
		APP_VO.put(GetProfile, RequestBody.class);
		APP_VO.put(GetBusinessManList, BusinessManListReq.class);
		APP_VO.put(GetBusinessManDetail, BusinessManDetailReq.class);
		APP_VO.put(GetProductList, ProductListReq.class);
		APP_VO.put(GetProductDetail, ProductDetailReq.class);
		APP_VO.put(ShoppingCartList, ShoppingCartListReq.class);
		/*
		
		
		
		 APP_VO.put(CreateCI, RequestBody.class); 
		
		APP_VO.put(UploadAvatar, RequestBody.class);
		
		
		APP_VO.put(GetProjectList, GetProjectListReq.class);
		APP_VO.put(GetProjectDetail, GetProjectDetailReq.class);
		APP_VO.put(AtteOrCan, AttentionOrCancelReq.class);
		APP_VO.put(FeedBack, FeedBackReq.class);
		APP_VO.put(GetVersion, GetVersionReq.class);*/

	}
}