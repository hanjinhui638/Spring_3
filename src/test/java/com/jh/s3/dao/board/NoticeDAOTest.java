package com.jh.s3.dao.board;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.jh.s3.TestAbstractCase;
import com.jh.s3.model.board.NoticeVO;

public class NoticeDAOTest extends TestAbstractCase{
	
	@Inject
	private NoticeDAO noticeDAO;
	
	//@Test
	public void checkDAO() throws Exception{
		assertNotNull(noticeDAO);
		
	}
	
	
	
	@Test
	public void noticeInsertTest() throws Exception{
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO.setTitle("a1");
		noticeVO.setWriter("kk");
		noticeVO.setContents("aaaa");
		
		int result = noticeDAO.noticeInsert(noticeVO);
		assertEquals(1, result);
		
	}

}
