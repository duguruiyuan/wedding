package com.fh.entity;

/**
 * 字典
 * 
 * @author wujinsong
 *
 */
public class Dictionary {
	/**
	 * id
	 */
	private Long zdId;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 编码
	 */
	private String bianMa;
	/**
	 * 排序
	 */
	private String ordyBy;
	/**
	 * 父id
	 */
	private Long parentId;
	/**
	 * 级别
	 */
	private String jb;
	/**
	 * 父编码
	 */
	private String pBm;

	public Long getZdId() {
		return zdId;
	}

	public void setZdId(Long zdId) {
		this.zdId = zdId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBianMa() {
		return bianMa;
	}

	public void setBianMa(String bianMa) {
		this.bianMa = bianMa;
	}

	public String getOrdyBy() {
		return ordyBy;
	}

	public void setOrdyBy(String ordyBy) {
		this.ordyBy = ordyBy;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getJb() {
		return jb;
	}

	public void setJb(String jb) {
		this.jb = jb;
	}

	public String getpBm() {
		return pBm;
	}

	public void setpBm(String pBm) {
		this.pBm = pBm;
	}
}
