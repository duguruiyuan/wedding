package com.fh.vo.response;

import java.util.ArrayList;
import java.util.List;

import com.fh.entity.Address;
import com.fh.vo.ResponseBody;

public class AddressListResp extends ResponseBody {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Address> addressList = new ArrayList<Address>();

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

}