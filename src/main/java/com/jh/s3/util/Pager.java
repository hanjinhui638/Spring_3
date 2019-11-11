package com.jh.s3.util;

public class Pager {

	private Integer curPage;
	private Integer perPage;
	private Integer startNum;
	private Integer lastNum;
	private Integer curBlock;
	private Integer totalBlock;
	
	public Pager(){
		perPage = 10;
	}
	

	public Integer getCurPage() {
		if(this.curPage == null) {
			this.curPage =1;
		}
		
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getStartNum() {
		return startNum;
	}

	public void setStartNum(Integer startNum) {
		this.startNum = startNum;
	}

	public Integer getLastNum() {
		return lastNum;
	}

	public void setLastNum(Integer lastNum) {
		this.lastNum = lastNum;
	}

	public Integer getPerPage() {
		return perPage;
	}

	public Integer getCurBlock() {
		return curBlock;
	}

	public Integer getTotalBlock() {
		return totalBlock;
	}
	
	public void makePager(int totalCount) {
		int totalPage = totalCount/perPage;
		
		if(totalCount%perPage !=0) {
			totalPage++;
		}
		
		int perBlock = 5;
		totalBlock = totalPage/perBlock;
		if(totalPage%perBlock !=0) {
			totalBlock++;
		}
		
		curBlock = curPage/perBlock;
		
		if(curPage%perBlock !=0) {
			curBlock++;
			
		}
		
		startNum = (curBlock-1)*perBlock+1;
		lastNum = curBlock*perBlock;
		if(curBlock == totalBlock) {
			lastNum = totalPage;
			
		}
	}
	
	public RowMaker makeRow() {
		int startRow = (this.getCurPage()-1)*perPage+1;
		int lastRow = this.getCurPage()*perPage;
		
		RowMaker rowMaker = new RowMaker();
		rowMaker.setStartRow(startRow);
		rowMaker.setLastRow(lastRow);
		
		return rowMaker;
		
	}
	
}
