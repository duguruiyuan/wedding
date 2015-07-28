package com.fh.vo;

public class ShortMessageResp {

	String code;
	String msg;
	MsgResult result;

	class MsgResult {

		String count;
		String fee;
		String sid;

		public String getCount() {
			return count;
		}

		public void setCount(String count) {
			this.count = count;
		}

		public String getFee() {
			return fee;
		}

		public void setFee(String fee) {
			this.fee = fee;
		}

		public String getSid() {
			return sid;
		}

		public void setSid(String sid) {
			this.sid = sid;
		}

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public MsgResult getResult() {
		return result;
	}

	public void setResult(MsgResult result) {
		this.result = result;
	}

}
