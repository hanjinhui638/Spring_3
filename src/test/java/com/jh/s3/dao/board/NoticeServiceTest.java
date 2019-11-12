package com.jh.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.jh.s3.TestAbstractCase;
import com.jh.s3.model.board.NoticeVO;
import com.jh.s3.service.board.NoticeService;
import com.jh.s3.util.Pager;


public class NoticeServiceTest extends TestAbstractCase{

	@Inject
	private NoticeService noticeService;
	
	@Test
	public void noticeListTest() throws Exception{
		
		Pager pager = new Pager();
		
		List<NoticeVO> ar = noticeService.noticeList(pager);
		assertNotEquals(0, ar.size());
		
		
	}
}
