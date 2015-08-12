package com.fh.entity;

public class MybatisPageable {
	private int total;
	private int pageSize;
	private int pageNumber;

	public MybatisPageable() {
	}

	public MybatisPageable(int pageSize,int pageNumber) {
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageTotal() {
		return this.getTotal() % this.getPageSize() == 0 ? this.getTotal() / this.getPageSize() : this.getTotal() / this.getPageSize() + 1;
	}

	public int getPageStart() {
		return this.pageSize*(this.pageNumber-1);
	}

	public int getPageEnd() {
		return this.getPageStart() + this.getPageSize() - 1;
	}
}
