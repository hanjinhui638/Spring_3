package com.jh.s3;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.jh.s3.dao.board.QnaDAO;
import com.jh.s3.model.board.QnaVO;

public class QnaDAOTest {

		@Inject
		private QnaDAO qnaDAO;
		
		//@Test
		public void checkDAO() throws Exception{
			assertNotNull(qnaDAO);
			
		}
		
		//@Test
		public void qnaInsertTest()throws Exception{
			QnaVO qnaVO = new QnaVO();
			
			qnaVO.setTitle("qt2");
			qnaVO.setWriter("qw2");
			qnaVO.setContents("qc2");
			
			int result = qnaDAO.qnaInsert(qnaVO);
			
			assertEquals(1, result);
			
		}
		
		//@Test
		public void qnaList()throws Exception{
			List<QnaVO> list = qnaDAO.qnaList();
			assertNotEquals(0, list.size());
			
		}
		
}
