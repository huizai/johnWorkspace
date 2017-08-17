package com.cn.hnust.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.cn.hnust.bean.OrderHeader;
import com.cn.hnust.dao.*;


@Service("orderHeadService")
public class OrderHeaderServiceImpl implements OrderHeaderService {
	private static final Logger logger = Logger.getLogger(OrderHeaderServiceImpl.class);
	 @Resource 
	public OrderHeaderMapper orderHeaderMapper;
	
	@Override
	public List<OrderHeader> getAll() {
		List<OrderHeader> list = new ArrayList<>();
		try {
			list.add(orderHeaderMapper.selectByPrimaryKey("Y5944128971"));
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		
		return list;
	}

}
