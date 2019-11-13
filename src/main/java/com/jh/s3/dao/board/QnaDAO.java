package com.jh.s3.dao.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jh.s3.model.board.QnaVO;
import com.jh.s3.util.Pager;


@Repository
public class QnaDAO {
	/* test */
	/* 로그인 - sql문(mapper) sqlSession이 필요(의존성) -> DB와 연결해서 sql문을통해 data를 넣거나 꺼냄 */

	@Inject
	private SqlSession sqlSession;
	/* 메서드에 공통적으로 쓰는 것 멤버변수로 */
	/* mapper */

	private static final String NAMESPACE = "qnaMapper."; /* 만들어진 String 객체가 없기 떄문에 주입 x static 대문자*/

	
	public int qnaReplyUpdate(QnaVO qnaVO)throws Exception{
			return sqlSession.update(NAMESPACE+"qnaReplyUpdate", qnaVO);
		
	}

	
	
	public int qnaReply(QnaVO qnaVO)throws Exception{
		return sqlSession.insert(NAMESPACE+"qnaReply", qnaVO );
	}
	
	
	public QnaVO qnaSelect(int num)throws Exception{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		return sqlSession.selectOne(NAMESPACE+"qnaSelect", map);
	}
	
	
	public int qnaCount(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"qnaCount", pager);
	
	}

	public List<QnaVO> qnaList(Pager pager)throws Exception{
		return sqlSession.selectList(NAMESPACE+"qnaList", pager);
	
	}

	
	public int qnaWrite(QnaVO qnaVO) throws Exception{
	
	return sqlSession.insert(NAMESPACE+"qnaWrite", qnaVO);
	
	
}
	
	
}
