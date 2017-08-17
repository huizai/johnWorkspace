package com.cn.hnust.dao;

import com.cn.hnust.bean.OrderHeader;

public interface OrderHeaderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(OrderHeader record);

    int insertSelective(OrderHeader record);

    OrderHeader selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(OrderHeader record);

    int updateByPrimaryKey(OrderHeader record);
}