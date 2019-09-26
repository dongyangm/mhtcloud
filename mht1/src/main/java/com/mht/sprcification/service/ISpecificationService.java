package com.mht.sprcification.service;

import com.mht.sprcification.bean.GoodSpecification;
import com.mht.util.beanUtils.ResultInfo;

import java.util.List;

public interface ISpecificationService {

    public ResultInfo save(List<GoodSpecification> list);

    public ResultInfo findGoodSpecificationBygGoodId(String goodId);

    public void deleteByGoodId(String goodId);

}
