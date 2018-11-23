package com.minshang.eps.util;

import java.util.List;

public class PageResult<T> {
	/**当前页 */
	private Integer currPage;
	/**一页显示的行数 */
	private Integer pageSize;
	/**总行数 */
	private Integer totalNum;
	/**查询结果集 */
	private List<T> list;
	
	public PageResult(){
		
	}
	
	public PageResult(Integer currPage, Integer pageSize, Integer totalNum,
			List<T> list) {
		super();
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.totalNum = totalNum;
		this.list = list;
	}

	public Integer getcurrPage() {
		return currPage;
	}

	public void setcurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "PageResult [currPage=" + currPage + ", pageSize=" + pageSize
				+ ", totalNum=" + totalNum + ", list=" + list + "]";
	}	
	
}
