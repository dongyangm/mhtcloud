package com.mht.order;

import com.mht.order.bean.Orders;
import com.mht.order.service.IOrderService;
import com.mht.util.beanUtils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private IOrderService orderService;

    /**
     * 生成或更新订单
     * @param orders
     * @return
     */
    @PostMapping ("/save")
    public ResultInfo save (@RequestBody Orders orders){

        return orderService.save(orders);

    }

    /**
     * 查询详情
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public ResultInfo findById (@PathVariable(name = "id") String id){
        return orderService.findById(id);
    }

    /**
     * 商家查询售出订单
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/findMyOrderForBusiness/{id}/{pageNum}/{pageSize}/{flag}")
    public ResultInfo findMyOrderForBusiness(@PathVariable("id") String id,
                                             @PathVariable("pageNum") int pageNum,
                                             @PathVariable("pageSize") int pageSize, @PathVariable("flag") int flag){

        return orderService.findMyOrderForBusiness(id, pageNum, pageSize,flag);

    }

    /**
     * 买家查询购买订单
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/findMyOrderForBuyer/{id}/{pageNum}/{pageSize}/{flag}")
    public ResultInfo findMyOrderForBuyer(@PathVariable("id") String id,
                                          @PathVariable("pageNum") int pageNum,
                                          @PathVariable("pageSize") int pageSize,
                                          @PathVariable("flag") int flag){

        return orderService.findMyOrderForBuyer(id, pageNum, pageSize,flag);
    }

    /**
     * 根据订单id删除订单
     * @param id
     * @return
     */
    @GetMapping("/deleteOrderById/{id}")
    public ResultInfo deleteOrderById(@PathVariable String id){
        return orderService.deleteOrderById(id);
    }

    @GetMapping("/getLogisticsInfo/{type}/{expNo}")
    public  ResultInfo getLogisticsInfo(@PathVariable String type, @PathVariable String expNo){
        return orderService.getLogisticsInfo(type,expNo);
    }

}
