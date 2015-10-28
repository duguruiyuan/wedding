package com.fh.service.system.appuser;

import java.util.Date;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.dao.BusinessManInfoMapper;
import com.fh.dao.FavoritesMapper;
import com.fh.dao.ProductInfoMapper;
import com.fh.entity.BusinessManInfo;
import com.fh.entity.Favorites;
import com.fh.entity.MybatisPageable;
import com.fh.entity.ProductInfo;
import com.fh.vo.ErrorResponseBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.FavoritesListReq;
import com.fh.vo.request.FavoritesReq;
import com.fh.vo.response.FavoritesListResp;

@Service
@Transactional
public class FavoritesService {

	@Autowired
	FavoritesMapper favoritesMapper;
	@Autowired
	BusinessManInfoMapper businessManInfoMapper;

	private static final DozerBeanMapper mapper = new DozerBeanMapper();

	public ResponseBody favorites(FavoritesReq favoritesReq, Long userId) {
		Favorites favorites;
		switch (favoritesReq.getType()) {
		case "1":
			favorites = favoritesMapper.selectByUserIdAndM(userId,
					favoritesReq.getManId());
			break;

		default:
			favorites = favoritesMapper.selectByUserIdAndP(userId,
					favoritesReq.getProductId());

			break;
		}
		// 关注
		if (favoritesReq.getFlag()) {

			if (favorites == null) {
				favorites = new Favorites();
				favorites.setCreateTime(new Date());
				mapper.map(favoritesReq, favorites);
				favorites.setUserId(userId);
				favoritesMapper.insert(favorites);
				return ResponseBody.createResponseBody("");
			}
			return ErrorResponseBody.createResponseBody("已关注");

		}

		else {
			if (favorites != null) {
				favoritesMapper.deleteByPrimaryKey(favorites.getId());
				return ResponseBody.createResponseBody("");
			}
			return ErrorResponseBody.createResponseBody("未关注");

		}
	}

	@Autowired
	ProductInfoMapper productInfoMapper;

	public ResponseBody favoritesList(FavoritesListReq favoritesListReq,
			Long userId) {
		List<BusinessManInfo> businessManInfos = null;
		List<ProductInfo> infos = null;
		switch (favoritesListReq.getType()) {
		case "1":
			businessManInfos = businessManInfoMapper.findBusinessManInfosByF(
					userId,
					new MybatisPageable(Integer.valueOf(favoritesListReq
							.getPageSize()), Integer.valueOf(favoritesListReq
							.getPageNo())));

			break;

		default:

			infos = productInfoMapper.findProductInfosByF(
					userId,
					new MybatisPageable(Integer.valueOf(favoritesListReq
							.getPageSize()), Integer.valueOf(favoritesListReq
							.getPageNo())));
			break;
		}

		FavoritesListResp favoritesListResp = new FavoritesListResp();
		favoritesListResp.setBusinessManList(businessManInfos);
		favoritesListResp.setProductList(infos);
		return favoritesListResp;
	}
}
