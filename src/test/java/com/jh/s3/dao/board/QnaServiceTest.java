package com.jh.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.jh.s3.TestAbstractCase;
import com.jh.s3.model.board.QnaVO;
import com.jh.s3.service.board.QnaService;
import com.jh.s3.util.Pager;

public class QnaServiceTest extends TestAbstractCase{
	
	@Inject
	private QnaService qnaService;
	
	@Test
	public void qnaListTest() throws Exception{
		
		Pager pager = new Pager();
		pager.makePager(50);
		
		List<QnaVO> ar = qnaService.qnaList(pager);
		//assertNotEquals(0, ar.size());
		//assertEquals(1, (int)pager.getStartRow());
		//assertEquals(10, (int)pager.getLastRow());0
		
	
		assertEquals(1, (int)pager.getStartNum());
		assertEquals(5, (int)pager.getLastNum()); 
	}


}
