package com.jh.s3.dao.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jh.s3.model.board.NoticeVO;

@Repository
public class NoticeDAO {
	
	
	
	
	@Inject
	private SqlSession sqlSession;
	private static final String NAMESPACE = "noticeMapper."; 
	
	

	
	
	  public int noticeUpdate(NoticeVO noticeVO)throws Exception{ 
		  return sqlSession.update(NAMESPACE+"noticeUpdate", noticeVO);
	  }
	 
	
	public List<NoticeVO> noticeList()throws Exception{
		 return sqlSession.selectList(NAMESPACE+"noticeList"); /* 알아서 List 생성 */
		
	}
	
	
	
	public NoticeVO noticeSelect(int num)throws Exception{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("num", num);
		return sqlSession.selectOne(NAMESPACE+"noticeSelect", map);
				
	}
	
	
	public int noticeDelete(int num)throws Exception{
		return sqlSession.delete(NAMESPACE+"noticeDelete", num);
		
	}
	
	public int noticeInsert(NoticeVO noticeVO) throws Exception{
		//num
	 return sqlSession.insert(NAMESPACE+"noticeInsert", noticeVO);
		
	}

}
