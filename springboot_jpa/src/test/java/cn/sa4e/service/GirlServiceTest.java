package cn.sa4e.service;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.sa4e.pojo.Girl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
	
	@Autowired
	private GirlService girlService;
	
	@Test
	public void girlService() throws Exception {
		Girl girl = girlService.findAgeTest(12);
		Assert.assertEquals(new Integer(19), girl.getAge());
	}
}
