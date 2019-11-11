package com.jh.s3.dao.board;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.jh.s3.model.board.QnAVO;
import com.jh.s3.util.RowMaker;

public class QnADAO {

@Inject
private SqlSession sqlSession;
private static final String NAMESPACE = "qnaMapper.";

public List<QnAVO> qnaList(RowMaker rowMaker)throws Exception{
	return sqlSession.selectList(NAMESPACE+"qnaList", rowMaker);
	
}
	
public int qnaInsert(QnAVO qnaVO) throws Exception{
	
	return sqlSession.insert(NAMESPACE+"qnaInsert", qnaVO);
	
	
}
	
	
}
