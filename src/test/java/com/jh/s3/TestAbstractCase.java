package com.jh.s3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) /* spring과연결 */
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/**/*-context.xml") /* 경로 */
public abstract class TestAbstractCase {


}
