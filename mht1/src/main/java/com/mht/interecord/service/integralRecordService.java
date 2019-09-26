package com.mht.interecord.service;

import com.mht.interecord.bean.IntegralRecord;
import com.mht.interecord.dao.IntegralRecordRepo;
import com.mht.util.beanUtils.PageInfo;
import com.mht.util.beanUtils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class integralRecordService implements IIntegralRecodService {

    @Autowired
    private IntegralRecordRepo integralRecordRepo;

    //商家查询所有积分记录
    public ResultInfo businessFindMyIntegralRecord(String businessId, int pageNum, int pagesize){
        PageRequest pageRequest = new PageRequest(pageNum - 1, pagesize);
        Page<IntegralRecord> records = integralRecordRepo.businessFindAllIntegralRecord(businessId, pageRequest);
        return new ResultInfo(true,new PageInfo(pageNum,pagesize,records.getTotalPages(),records.getContent()),1);
    }

    //商家分组查询用户积分记录
    public ResultInfo businessFindBuyerGroup(String businessId, int pageNum, int pageSize){
        PageRequest pageRequest = new PageRequest(pageNum-1, pageSize);
        Page<IntegralRecord> integralRecords = integralRecordRepo.businessFindGroupByUserId(businessId, pageRequest);
        return new ResultInfo(true,new PageInfo(pageNum,pageSize,(int) integralRecords.getTotalPages(),integralRecords.getContent()),1);
    }

    //商家查询用户，或用户查询商家所有记录
    public ResultInfo businessFindRecord(String businessId, String userId, int pageNum, int pageSize){
        PageRequest pageRequest = new PageRequest(pageNum-1, pageSize);
        Page<IntegralRecord> records = integralRecordRepo.findRecordsByBusinessIdAndUserId(businessId, userId, pageRequest);
        return new ResultInfo(true,new PageInfo(pageNum,pageSize,records.getTotalPages(),records.getContent()),1);
    }

    //买家查询所有积分记录
    public ResultInfo buyerFindAllIntegralRecord(String userId, int pageNum, int pagesize){
        PageRequest pageRequest = new PageRequest(pageNum-1, pagesize);
        Page<IntegralRecord> records = integralRecordRepo.buyerFindAllRecord(userId, pageRequest);
        return new ResultInfo(true,new PageInfo(pageNum,pagesize,(int) records.getTotalPages(),records.getContent()),1);
    }

    //买家分组查询商家积分记录
    public ResultInfo buyerFindBusinessGroup(String userId, int pageNum, int pageSize){
        PageRequest pageRequest = new PageRequest(pageNum-1, pageSize);
        return new ResultInfo(true,integralRecordRepo.buyerFindBusinessGroup(userId,pageRequest),1);
    }

    //根据id删除积分记录
    @Transactional
    public ResultInfo deleteById(String id){
        integralRecordRepo.deleteById(id);
        return new ResultInfo(true,null,1);
    }

}
