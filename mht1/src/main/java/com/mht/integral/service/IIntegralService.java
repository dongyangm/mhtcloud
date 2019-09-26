package com.mht.integral.service;

import com.mht.integral.bean.Integral;
import com.mht.util.beanUtils.ResultInfo;

public interface IIntegralService {

    //查询积分
    public ResultInfo updateIntegral(Integral param);

    public ResultInfo buyerFindMyintegral(String id, int pageNum, int Pagesize);

    public ResultInfo buyerFindByBusinessName(String buyerId, String businessName);

    public ResultInfo findFirstByBusinessIdAndUserId(String userId, String businessId);

    public ResultInfo findIntegralsByBusinessId(String businessId, int pageNum, int pageSize);
}
