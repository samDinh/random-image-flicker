package com.sdn.randomimageflicker;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import sdn.flicker.RandomImageFlickerApplication;

@ContextConfiguration(classes = RandomImageFlickerApplication.class)
@WebAppConfiguration
//		@IntegrationTest
public class RandomImageFlickerApplicationTests {

	@Test
	public void contextLoads() {
	}

}
