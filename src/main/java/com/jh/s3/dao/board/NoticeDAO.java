package com.jh.s3.dao.board;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jh.s3.model.board.NoticeVO;

@Repository
public class NoticeDAO {
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "noticeMapper."; 
	
	public int noticeInsert(NoticeVO noticeVO) throws Exception{
		//num
	 return sqlSession.insert(NAMESPACE+"noticeInsert", noticeVO);
		
	}

}
