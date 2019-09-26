package com.mht.order.dao;

import com.mht.order.bean.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;

public interface OrderRepo extends JpaRepository<Orders,String>, JpaSpecificationExecutor<Orders>, Serializable {

    //查询买家未发货
    @Query(value = "select * from orders  where  buyer_id = :id and del_flag = 0 and order_flag = 0",nativeQuery = true)
    Page<Orders>findUnFillOrderForBuyer(@Param(value = "id") String buyerId, Pageable pageable);

    //查询买家待收货
    @Query(value = "select * from orders  where  buyer_id = :id and del_flag = 0 and track_num is not null and order_flag = 1",nativeQuery = true)
    Page<Orders>findWaitOrderForBuyer(@Param(value = "id") String buyerId, Pageable pageable);

    //查询买家已收货和取消订单
    @Query(value = "select * from orders  where  buyer_id = :id and del_flag = 0 and order_flag = :flag",nativeQuery = true)
    Page<Orders>findReceivedOrderForBuyer(@Param(value = "id") String businessId, @Param(value = "flag") int flag, Pageable pageable);

    //查询买家所有订单
    @Query(value = "select * from orders  where  buyer_id = :id and del_flag = 0",nativeQuery = true)
    Page<Orders>findMyOrderForBuyer(@Param(value = "id") String buyerId, Pageable pageable);

    //查询卖家未发货
    @Query(value = "select * from orders  where  merchat_id = :id and del_flag = 0 and track_num is null",nativeQuery = true)
    Page<Orders>findUnFillOrderForBusiness(@Param(value = "id") String buyerId, Pageable pageable);

    //查询买家待收货
    @Query(value = "select * from orders  where  merchat_id = :id and del_flag = 0 and track_num is not null and order_flag = 1",nativeQuery = true)
    Page<Orders>findWaitOrderForBusiness(@Param(value = "id") String buyerId, Pageable pageable);

    //查询买家已收货和取消订单
    @Query(value = "select * from orders  where  merchat_id = :id and del_flag = 0 and order_flag = :flag",nativeQuery = true)
    Page<Orders>findReceivedOrderForBusiness(@Param(value = "id") String businessId, @Param(value = "flag") int flag, Pageable pageable);

    //查询卖家所有订单
    @Query(value = "select * from orders  where merchat_id  = :id and del_flag = 0",nativeQuery = true)
    Page<Orders>findMyOrderForBusiness(@Param(value = "id") String merchatId, Pageable pageable);

    //确认或取消订单
    @Query(value = "update orders set order_flag = :flag,read_flag = 0 where buyer_id = :buyerId",nativeQuery = true)
    int updateOrOrderByBuyId(@Param(value = "buyerId") String buyerId, @Param(value = "flag") int flag);

}
