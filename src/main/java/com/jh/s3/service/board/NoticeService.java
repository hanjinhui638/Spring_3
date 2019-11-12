package com.jh.s3.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jh.s3.dao.board.NoticeDAO;
import com.jh.s3.model.board.NoticeVO;
import com.jh.s3.util.Pager;
import com.jh.s3.util.RowMaker;

@Service
public class NoticeService {

	@Inject
	private NoticeDAO noticeDAO;
	
	
	
	//list
	public List<NoticeVO> noticeList(Pager pager, RowMaker rowMaker)throws Exception{
		pager.makeRow();		
		pager.makePager(noticeDAO.noticeCount(rowMaker));
		/*
		 * TEST
		 * System.out.println(rowMaker.getStartRow());
		 * System.out.println(rowMaker.getLastRow());
		 */
		 return noticeDAO.noticeList(rowMaker);
	
	}
	
	
	//select
	public NoticeVO noticeSelect(int num)throws Exception{
			return noticeDAO.noticeSelect(num);
		
	}
	
	
	//update
	
	  public int noticeUpdate(NoticeVO noticeVO)throws Exception{ 
		  return noticeDAO.noticeUpdate(noticeVO); 
	 }
	
	
	
	public int noticeDelete(int num)throws Exception{
			 return noticeDAO.noticeDelete(num);
		
	}
	
	public int noticeInsert(NoticeVO noticeVO)throws Exception{
		 return noticeDAO.noticeInsert(noticeVO);
		
	}
	

	
}
