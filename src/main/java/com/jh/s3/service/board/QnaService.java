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
	
	public int qnaReply(QnaVO qnaVO)throws Exception{
		/* 부모의 글번호가 넘어옴 */
		//부모의 정보 
		QnaVO parent = qnaDAO.qnaSelect(qnaVO.getNum()); /* 새로 선언-> 부모의 글로 덮어 씌어지지 않기 위해서 */
		int result = qnaDAO.qnaReplyUpdate(parent);
		System.out.println(parent.getStep());
		qnaVO.setRef(parent.getRef());
		qnaVO.setStep(parent.getStep()+1);
		qnaVO.setDepth(parent.getDepth()+1);
		
		result = qnaDAO.qnaReply(qnaVO);
		return result;
		
	}
	
	public QnaVO qnaSelect(int num)throws Exception{
		return qnaDAO.qnaSelect(num);
		
		
	}
	
	public int qnaWrite(QnaVO qnaVO)throws Exception{
		return qnaDAO.qnaWrite(qnaVO);
		
	}
	
	public List<QnaVO> qnaList(Pager pager)throws Exception{
		//DB rownum 계산 
		
		
		
		pager.makeRow();
		/* int count = qnaDAO.qnaCount();  여러번 사용할때 */
		pager.makePager(qnaDAO.qnaCount(pager));
		return qnaDAO.qnaList(pager);
		
	}
	
	
	
}
