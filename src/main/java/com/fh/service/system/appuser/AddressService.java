package com.fh.service.system.appuser;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fh.dao.AddressMapper;
import com.fh.entity.Address;
import com.fh.entity.MybatisPageable;
import com.fh.vo.ErrorResponseBody;
import com.fh.vo.ResponseBody;
import com.fh.vo.request.AddressListReq;
import com.fh.vo.request.AddressReq;
import com.fh.vo.response.AddressListResp;

@Service
@Transactional
public class AddressService {

	@Autowired
	private AddressMapper addressMapper;

	private static final DozerBeanMapper mapper = new DozerBeanMapper();

	public ResponseBody address(AddressReq addressReq, Long userId) {
		Address address = null;
		if (addressReq.getId() == null)
			address = new Address();
		else
			address = addressMapper.selectByPrimaryKey(addressReq.getId());
		if (address == null)
			return ErrorResponseBody.createResponseBody("地址不存在");
		if (address.getUserId() != null & !address.getUserId().equals(userId))
			return ErrorResponseBody.createResponseBody("地址错误");

		if (addressReq.getDefaultFlag()) {
			if (!address.getDefaultFlag()) {
				Address address2 = addressMapper.selectByDefaultFlag(true);
				if (null != address2) {
					address2.setDefaultFlag(false);
					addressMapper.updateByPrimaryKey(address2);
				}
			}
		}
		mapper.map(addressReq, address);
		address.setUserId(userId);
		if (address.getId() != null)
			addressMapper.updateByPrimaryKey(address);
		else
			addressMapper.insert(address);
		return ResponseBody.createResponseBody("");
	}

	public ResponseBody addressList(AddressListReq addressListReq, Long userId) {
		List<Address> list = addressMapper.findAddressList(
				addressListReq,
				userId,
				new MybatisPageable(Integer.valueOf(addressListReq
						.getPageSize()), Integer.valueOf(addressListReq
						.getPageNo())));
		AddressListResp addressListResp = new AddressListResp();
		addressListResp.setStatus("000000");
		addressListResp.setAddressList(list);
		return addressListResp;
	}
}
