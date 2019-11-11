package com.jh.s3;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.jh.s3.dao.board.QnaDAO;
import com.jh.s3.model.board.QnaVO;
import com.jh.s3.util.RowMaker;

public class QnaDAOTest extends TestAbstractCase{

		@Inject
		private QnaDAO qnaDAO;
		
		//@Test
		public void checkDAO() throws Exception{
			assertNotNull(qnaDAO);
			
		}
		
		//@Test
		public void qnaInsertTest()throws Exception{
			
			for(int i=0;i<150;i++) {
			QnaVO qnaVO = new QnaVO();
			
			qnaVO.setTitle("qt"+i);
			qnaVO.setWriter("qw"+i);
			qnaVO.setContents("qc"+i);
			
			int result = qnaDAO.qnaInsert(qnaVO);
			
			}
			//assertEquals(1, result);
			
		}
		
		@Test
		public void qnaList(RowMaker rowMaker)throws Exception{
			List<QnaVO> list = qnaDAO.qnaList(rowMaker);
			assertNotEquals(0, list.size());
			
		}
		
}
