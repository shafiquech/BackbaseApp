package com.backbase.api.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:backbase-servlet.xml" })
public class ApiTest {

	@Test
	public void test() throws Exception {
		System.out.println("Test is running...");
	}

}
