package com.mht.integral.service;

import com.mht.integral.bean.Integral;
import com.mht.integral.dao.IntegralRepo;
import com.mht.interecord.bean.IntegralRecord;
import com.mht.interecord.dao.IntegralRecordRepo;
import com.mht.util.beanUtils.PageInfo;
import com.mht.util.beanUtils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class IntegralService implements IIntegralService{

    @Autowired
    private IntegralRepo integralRepo;

    @Autowired
    private IntegralRecordRepo integralRecordRepo;

    @Transactional
    public ResultInfo updateIntegral(Integral param){
        Integral integral = integralRepo.findFirstByBusinessIdAndUserId(param.getBusinessId(), param.getUserId());
        if (integral != null && integral.getId() != null && integral.getId().length() > 0){
            //存在记录
            int inte = param.getAvailIntegral();
            if (inte>=0){
                //新增积分
                integral.setTotalntegral(integral.getTotalIntegral()+inte);
                integral.setAvailIntegral(integral.getAvailIntegral()+inte);
                integral.setUpdateTime(new Date());
                insertIntegralRecord(param);
                return new ResultInfo(true,integralRepo.save(integral),1);
            }
            if (inte < 0){
                //判断积分是否可消耗
                if (Math.abs(inte) <= integral.getAvailIntegral()){
                    //消耗积分
                    integral.setAvailIntegral(integral.getAvailIntegral()+inte);
                    integral.setUsedIntegral(integral.getUsedIntegral()+ Math.abs(inte));
                    integral.setUpdateTime(new Date());
                    insertIntegralRecord(param);
                    return new ResultInfo(true,integralRepo.save(integral),1);
                }
                //积分不足
                return new ResultInfo(true,null,-1);
            }

        }
        param.setId(UUID.randomUUID().toString().replace("-",""));
        param.setTotalntegral(param.getAvailIntegral());
        param.setCreateTime(new Date());
        param.setUpdateTime(new Date());
        insertIntegralRecord(param);
        return new ResultInfo(true,integralRepo.save(param),1);
    }


    //插入积分记录
    private Boolean insertIntegralRecord(Integral integral){
        IntegralRecord integralRecord = new IntegralRecord();
        integralRecord.setId(UUID.randomUUID().toString().replace("-",""));
        integralRecord.setUserId(integral.getUserId());
        integralRecord.setUserName(integral.getUserName());
        integralRecord.setBusinessId(integral.getBusinessId());
        integralRecord.setBusinessName(integral.getBusinessName());
        integralRecord.setHaveTime(new Date());
        integralRecord.setHaveIntegral(integral.getAvailIntegral());
        IntegralRecord save = integralRecordRepo.save(integralRecord);
        if(save != null){
            return true;
        }
        return false;
    }

    //买家查询我的积分
    public ResultInfo buyerFindMyintegral(String userId,int pageNum,int pageSize){

        Pageable page = new PageRequest(pageNum-1, pageSize);

        Page<Integral> integrals = integralRepo.findMyIntegral(userId, page);
        return new ResultInfo(true,new PageInfo(pageNum,pageSize,integrals.getTotalPages(),integrals.getContent()),1);
    }

    //买家根据商家名称查询
    public ResultInfo buyerFindByBusinessName(String buyerId,String businessName){

        return new ResultInfo(true,integralRepo.findIntegralsByBusinessNameLikeAndAndUserId("%"+businessName+"%",buyerId),1);

    }

    @Override
    public ResultInfo findFirstByBusinessIdAndUserId(String userId, String businessId) {
        Integral integral = integralRepo.findFirstByBusinessIdAndUserId(userId, businessId);
        return new ResultInfo(true,integral,1);
    }

    public ResultInfo findIntegralsByBusinessId(String businessId,int pageNum,int pageSize){

        Pageable page = new PageRequest(pageNum-1, pageSize);
        Page<Integral> integrals = integralRepo.findIntegralsByBusinessId(businessId, page);
        return new ResultInfo(true,new PageInfo(pageNum,pageSize,integrals.getTotalPages(),integrals.getContent()),1);
    }
}
