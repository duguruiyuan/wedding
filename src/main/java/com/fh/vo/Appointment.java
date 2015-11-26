package com.fh.vo;

/**
 * 预约
 * @author jswul
 *
 */
public class Appointment {
	/**
	 * 手机号码
	 */
	private String phone;
	
	/**
	 * 是否黄道吉日
	 */
	private String isLuckyDay;
	
	/**
	 * 是否双休日
	 */
	private String isWeekend;
	
	/**
	 * 是否双号日
	 */
	private String isEvenNumbers;
	
	/**
	 * 桌数
	 */
	private String tableNumber; 
	
	/**
	 * 短信验证码
	 */
	private String smsVerificationCode;
	
	/**
	 * 创建时间
	 */
	private String createtime;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIsLuckyDay() {
		return isLuckyDay;
	}

	public void setIsLuckyDay(String isLuckyDay) {
		this.isLuckyDay = isLuckyDay;
	}

	public String getIsWeekend() {
		return isWeekend;
	}

	public void setIsWeekend(String isWeekend) {
		this.isWeekend = isWeekend;
	}

	public String getIsEvenNumbers() {
		return isEvenNumbers;
	}

	public void setIsEvenNumbers(String isEvenNumbers) {
		this.isEvenNumbers = isEvenNumbers;
	}

	public String getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}

	public String getSmsVerificationCode() {
		return smsVerificationCode;
	}

	public void setSmsVerificationCode(String smsVerificationCode) {
		this.smsVerificationCode = smsVerificationCode;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
}
