package com.jh.s3;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;


public class SqlSessionTest extends TestAbstractCase{

	@Inject
	private SqlSession sqlSession;
	
	//@Inject
	private DataSource dataSource;
	
	@Test
	public void sqlTest() {
		
		assertNotNull(sqlSession);
		
		
		/* root-context.xml Test*/
	}
	

}
