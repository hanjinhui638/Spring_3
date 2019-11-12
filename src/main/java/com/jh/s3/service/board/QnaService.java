package com.jh.s3.service.board;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.jh.s3.dao.board.QnaDAO;
import com.jh.s3.model.board.QnaVO;
import com.jh.s3.util.Pager;

@Service
public class QnaService {
	
	@Inject
	private QnaDAO qnaDAO;
	
	public List<QnaVO> qnaList(Pager pager)throws Exception{
		//DB rownum 계산 
		
		
		
		pager.makeRow();
		/* int count = qnaDAO.qnaCount();  여러번 사용할때 */
		pager.makePager(qnaDAO.qnaCount(pager));
		return qnaDAO.qnaList(pager);
		
	}
	
	public int qnaInsert(QnaVO qnaVO)throws Exception{
		return qnaDAO.qnaInsert(qnaVO);
		
	}
	
}
