package com.jh.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.jh.s3.TestAbstractCase;
import com.jh.s3.model.board.NoticeVO;
import com.jh.s3.util.Pager;

public class NoticeDAOTest extends TestAbstractCase{
	
	@Inject
	private NoticeDAO noticeDAO;
	
	
	
	//@Test
	public void checkDAO() throws Exception{
		assertNotNull(noticeDAO);
		
	}
	
	
	@Test
	public void noticeCountTest(Pager pager)throws Exception{
		int count = noticeDAO.noticeCount(pager);
		assertEquals(87, count);
	}
	
	
	//@Test
	public void noticeInsertTest() throws Exception{
		
		for(int i=0;i<120;i++) {
		NoticeVO noticeVO = new NoticeVO();
		
		noticeVO.setTitle("nt"+i);
		noticeVO.setWriter("nw"+i);
		noticeVO.setContents("nc"+i);
		
		int result = noticeDAO.noticeInsert(noticeVO);
		
		}
		//assertEquals(1, result);
		
	}

	//@Test
	public void noticeDeleteTest()throws Exception{
		int result = noticeDAO.noticeDelete(2);
		assertEquals(1, result);
		
	}
	
	//@Test
	public void noticeSelect()throws Exception{
		NoticeVO noticeVO = noticeDAO.noticeSelect(3);
		assertNotNull(noticeVO);
	}
	
	//@Test
	public void noticeList()throws Exception{
		List<NoticeVO> list = noticeDAO.noticeList(null);
		assertNotEquals(0, list.size());
	}
	
	
	
	
	 //@Test 
	 public void noticeUpdate()throws Exception{ 
		 NoticeVO noticeVO = new NoticeVO();
	 
		 noticeVO.setTitle("a1"); 
		 noticeVO.setContents("aaaa");
		 noticeVO.setNum(5);
	 
		 int result = noticeDAO.noticeUpdate(noticeVO); 
		 assertEquals(1, result); 
	 }
	
	 
	 
	
	
}
