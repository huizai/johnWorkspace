package com.cn.hnust;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.alibaba.fastjson.JSON;
import com.cn.hnust.bean.OrderHeader;
import com.cn.hnust.service.OrderHeaderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestMybatis {

	private static final Logger logger = Logger.getLogger(TestMybatis.class);
	 @Resource 
	public OrderHeaderService orderHeadService;


	@Test
	public void testgetOrderHeaderList(){
		List<OrderHeader> list= orderHeadService.getAll();
		logger.debug(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
//
//	@Test
//	public void test1() {
//		User u = userService.getUserById("1");
//		logger.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd HH:mm:ss"));
//	}
//
//	@Test
//	public void test2() {
//		List<User> l = userService.getAll();
//		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
//	}
//
//	@Test
//	public void test3() {
//		List<User> l = userService.getAll2();
//		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
//	}
//
//	@Test
//	public void test4() {
//		List<User> l = userService.getAll3();
//		logger.info(JSON.toJSONStringWithDateFormat(l, "yyyy-MM-dd HH:mm:ss"));
//	}
}
