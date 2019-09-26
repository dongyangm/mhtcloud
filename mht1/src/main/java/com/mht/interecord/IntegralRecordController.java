package com.mht.interecord;

import com.mht.interecord.service.IIntegralRecodService;
import com.mht.util.beanUtils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/integralRecord")
public class IntegralRecordController {

    @Autowired
    private IIntegralRecodService integralRecodService;

    //商家查询所有积分记录
    @GetMapping("/businessFindMyIntegralRecord/{businessId}/{pageNum}/{pageSize}")
    public ResultInfo businessFindMyIntegralRecord(@PathVariable String businessId, @PathVariable int pageNum, @PathVariable int pageSize){

        return integralRecodService.businessFindMyIntegralRecord(businessId,pageNum,pageSize);
    }

    //商家分组查询用户积分记录
    @GetMapping("/businessFindBuyerGroup/{businessId}/{pageNum}/{pageSize}")
    public ResultInfo businessFindBuyerGroup(@PathVariable String businessId, @PathVariable int pageNum, @PathVariable int pageSize){
        return integralRecodService.businessFindBuyerGroup(businessId,pageNum,pageSize);
    }

    //商家查询用户，或用户查询商家所有记录
    @GetMapping("/businessFindRecord/{businessId}/{userId}/{pageNum}/{pageSize}")
    public ResultInfo businessFindRecord(@PathVariable String businessId, @PathVariable String userId, @PathVariable int pageNum, @PathVariable int pageSize){
        return integralRecodService.businessFindRecord( businessId, userId,pageNum,pageSize);
    }

    //买家查询所有积分记录
    @GetMapping("/buyerFindAllIntegralRecord/{userId}/{pageNum}/{pageSize}")
    public ResultInfo buyerFindAllIntegralRecord(@PathVariable int pageNum, @PathVariable String userId, @PathVariable int pageSize){

        return integralRecodService.buyerFindAllIntegralRecord( userId, pageNum, pageSize);
    }

    //买家分组查询商家积分记录
    @GetMapping("/buyerFindBusinessGroup/{userId}/{pageNum}/{pageSize}")
    public ResultInfo businessFindBusinessGroup(@PathVariable String userId, @PathVariable int pageNum, @PathVariable int pageSize){
        return integralRecodService.buyerFindBusinessGroup(userId,pageNum,pageSize);
    }

    //根据id删除积分记录
    @GetMapping("/deleteById/{id}")
    public ResultInfo deleteById(@PathVariable String id){
        return integralRecodService.deleteById(id);
    }
}
