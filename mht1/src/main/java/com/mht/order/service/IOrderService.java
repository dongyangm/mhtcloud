package com.mht.order.service;

import com.mht.order.bean.Orders;
import com.mht.util.beanUtils.ResultInfo;

public interface IOrderService {

    public ResultInfo save (Orders orders);

    public ResultInfo findById(String id);

    public ResultInfo findMyOrderForBusiness(String id, int pageNum, int pageSize, int flag);

    public ResultInfo findMyOrderForBuyer(String id, int pageNum, int pageSize, int flag);

    public ResultInfo deleteOrderById(String id);
    public ResultInfo getLogisticsInfo(String expType,String expNo);

}
