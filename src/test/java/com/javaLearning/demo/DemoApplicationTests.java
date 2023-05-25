package com.javaLearning.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.util.AssertionErrors.assertEquals;
import static org.springframework.test.util.AssertionErrors.assertTrue;

@SpringBootTest
class DemoApplicationTests {
	DemoApplication d1=new DemoApplication();

	@Test
	void contextLoads() {
		assertEquals("successfull",true,d1.solve("Hi","Hi"));
		assertTrue(true,);
	}

}
