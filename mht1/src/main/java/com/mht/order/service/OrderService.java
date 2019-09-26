package com.mht.order.service;

import com.alibaba.fastjson.JSON;
import com.mht.goods.bean.Good;
import com.mht.goods.service.IGoodService;
import com.mht.integral.bean.Integral;
import com.mht.integral.service.IIntegralService;
import com.mht.order.bean.Orders;
import com.mht.order.dao.OrderRepo;
import com.mht.util.beanUtils.PageInfo;
import com.mht.util.beanUtils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private IIntegralService integralService;

    @Autowired
    private IGoodService goodService;

    @Value("${eBusinessID}")
    private String EBusinessID;

    @Autowired
    private LogisticsUtil logisticsUtil;

    @Transactional
    public ResultInfo save (Orders orders){
        //新增订单
        if (orders.getOrderId() == null){
            orders.setOrderId(Math.abs(UUID.randomUUID().toString().replace("-","").hashCode())+"");
            orders.setCreateTime(new Date());//初始化订单时间
            orders.setDelFlag(0);//初始化未删除
            orders.setOrderFlag(0);//初始化未收货
            orders.setReadFlag(0);//初始化未读
            return new ResultInfo(true,orderRepo.save(orders),1);
        }

        //确认订单或取消订单
        if ((orders.getOrderFlag() == 2 || orders.getOrderFlag() == 3) && orders.getDealingTime() == null){
            orders.setDealingTime(new Date());
            if (orders.getOrderFlag() == 2){
                //确认订单，积分新增记录
                Integral integral = new Integral();
                integral.setUserId(orders.getBuyerId());
                integral.setUserName(orders.getBuyerName());
                integral.setBusinessId(orders.getMerchatId());
                integral.setBusinessName(orders.getMerchatName());
                integral.setAvailIntegral(orders.getGoodNum());
                integralService.updateIntegral(integral);
                //订单完成，更新商品已售数量
                ResultInfo byId = goodService.findById(orders.getGoodId());
                if (byId.getData() != null ){
                    Good data = (Good)byId.getData();
                    data.setSoldNum(data.getSoldNum()+orders.getGoodNum());
                    goodService.save(data);
                }

            }
            return new ResultInfo(true,orderRepo.save(orders),1);
        }
        //修改订单
        return new ResultInfo(true,orderRepo.save(orders),1);
    }

    public ResultInfo findById (String id){
        return new ResultInfo(true,orderRepo.findById(id).orElse(null),1);
    }

    //根据条件查询买家订单
    public ResultInfo findMyOrderForBuyer(String id, int pageNum, int pageSize, int flag){
        Sort sort = new Sort(Sort.Direction.DESC, "create_time");
        Pageable pageable = new PageRequest(pageNum - 1, pageSize, sort);
        //flag:0、未发货，1、待收货,2、已收货,3、取消订单,4、所有订单
        if (flag == 0){
            Page<Orders> order = orderRepo.findUnFillOrderForBuyer(id, pageable);
            return new ResultInfo(true,new PageInfo(pageNum, pageSize, (int) order.getTotalElements(), order.getContent()),1);
        }
        if (flag == 1){
            Page<Orders> order = orderRepo.findWaitOrderForBuyer(id, pageable);
            return new ResultInfo(true,new PageInfo(pageNum, pageSize, (int) order.getTotalElements(), order.getContent()),1);
        }
        if (flag == 2){
            Page<Orders> order = orderRepo.findReceivedOrderForBuyer(id,flag, pageable);
            return new ResultInfo(true,new PageInfo(pageNum, pageSize, (int) order.getTotalElements(), order.getContent()),1);
        }
        if (flag == 3){
            Page<Orders> order = orderRepo.findReceivedOrderForBuyer(id,flag, pageable);
            return new ResultInfo(true,new PageInfo(pageNum, pageSize, (int) order.getTotalElements(), order.getContent()),1);
        }
        Page<Orders> order = orderRepo.findMyOrderForBuyer(id, pageable);
        return new ResultInfo(true,new PageInfo(pageNum, pageSize, (int) order.getTotalElements(), order.getContent()),1);
    }


    //卖家查询获得订单
    public ResultInfo findMyOrderForBusiness(String id, int pageNum, int pageSize, int flag){
        Sort sort = new Sort(Sort.Direction.DESC, "create_time");
        Pageable pageable = new PageRequest(pageNum - 1, pageSize, sort);
        //flag:0、未发货，1、待收货,2、已收货,3、取消订单,4、查询所有
        if (flag == 0 ){
            Page<Orders> order = orderRepo.findUnFillOrderForBusiness(id,pageable);
            return new ResultInfo(true,new PageInfo(pageNum, pageSize, (int) order.getTotalElements(), order.getContent()),1);
        }
        if (flag == 1 ){
            Page<Orders> order = orderRepo.findWaitOrderForBusiness(id,pageable);
            return new ResultInfo(true,new PageInfo(pageNum, pageSize, (int) order.getTotalElements(), order.getContent()),1);
        }
        if (flag == 2){
            Page<Orders> order = orderRepo.findReceivedOrderForBusiness(id,flag,pageable);
            return new ResultInfo(true,new PageInfo(pageNum, pageSize, (int) order.getTotalElements(), order.getContent()),1);
        }
        if (flag == 3){
            Page<Orders> order = orderRepo.findReceivedOrderForBusiness(id,flag,pageable);
            return new ResultInfo(true,new PageInfo(pageNum, pageSize, (int) order.getTotalElements(), order.getContent()),1);
        }

        Page<Orders> order = orderRepo.findMyOrderForBusiness(id, pageable);
        return new ResultInfo(true,new PageInfo(pageNum, pageSize, (int) order.getTotalElements(), order.getContent()),1);
    }

    @Override
    @Transactional
    public ResultInfo deleteOrderById(String id) {
        Optional<Orders> byId = orderRepo.findById(id);
        Orders orders = byId.orElse(null);
        if (orders != null){
            orders.setDelFlag(1);
            orderRepo.save(orders);
        }
        return new ResultInfo(true,null,1);
    }

    /**
     * 查询物流信息
     * @param expType
     * @param expNo
     * @return
     */
    @Override
    public ResultInfo getLogisticsInfo(String expType, String expNo) {
        try {
            String result = logisticsUtil.getOrderTracesByJson(expType, expNo);
            return new ResultInfo(true,JSON.toJSON(result),1);
        }catch (Exception e){
            e.printStackTrace();
            return new ResultInfo(true,"",-1);
        }
    }

}
