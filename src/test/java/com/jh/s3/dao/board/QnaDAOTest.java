package com.jh.s3.dao.board;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.jh.s3.TestAbstractCase;
import com.jh.s3.dao.board.QnaDAO;
import com.jh.s3.model.board.QnaVO;
import com.jh.s3.util.RowMaker;

public class QnaDAOTest extends TestAbstractCase{

		@Inject
		private QnaDAO qnaDAO;
		
		/* new로 생성하면 sqlSession 주입 x */
		
		//@Test
		public void Test() throws Exception{
			this.qnaListTest();
		}
		
		
		private void qnaDAOTest() {
			
			assertNotNull(qnaDAO);
			
		}
		
		private void qnaListTest() throws Exception{
			List<QnaVO> ar = qnaDAO.qnaList();
			assertNotEquals(0, ar.size());
			
		}
		
		
		
		@Test
		public void qnaInsertTest()throws Exception{
			
			QnaVO qnaVO = new QnaVO();
			for(int i=0;i<3;i++) {
			
			qnaVO.setTitle("qt"+i);
			qnaVO.setWriter("qw"+i);
			qnaVO.setContents("qc"+i);
			
			int result = qnaDAO.qnaInsert(qnaVO);
			
			}
			//assertEquals(1, result);
			
		}
		
		
		
}
