package com.mht.integral;

import com.mht.integral.bean.Integral;
import com.mht.integral.service.IIntegralService;
import com.mht.util.beanUtils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/integral")
public class IntegralController {

    @Autowired
    private IIntegralService integralService;

    //买家查询我的积分
    @GetMapping("/buyerFindIntegral/{userId}/{pageNum}/{pageSize}")
    public ResultInfo buyerFindIntegral(@PathVariable("userId") String userId, @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){

        return integralService.buyerFindMyintegral(userId,pageNum,pageSize);

    }

    //买家根据商家名称查询
    @GetMapping("/buyerFindByBusinessName/{userId}/{businessName}")
    public ResultInfo buyerFindByBusinessName(@PathVariable String userId, @PathVariable String businessName){

        return integralService.buyerFindByBusinessName(userId,businessName);

    }
    //商家查询相关买家的积分(买家查询商家积分)
    @GetMapping("/findBusinessIdAndAndUserId/{userId}/{businessId}")
    public ResultInfo findBusinessIdAndAndUserId(@PathVariable String userId, @PathVariable String businessId){

        return integralService.findFirstByBusinessIdAndUserId(businessId,userId);
    }

    //商家查询积分列表
    @GetMapping("/findIntegralsByBusinessId/{businessId}/{pageNum}/{pageSize}")
    public ResultInfo findIntegralsByBusinessId( @PathVariable String businessId,@PathVariable int pageNum,@PathVariable int pageSize){

        return integralService.findIntegralsByBusinessId(businessId,pageNum,pageSize);

    }

    @PostMapping("/updateIntegral")
    public ResultInfo updateIntegral(@RequestBody Integral integral){

        return integralService.updateIntegral(integral);


    }



}
