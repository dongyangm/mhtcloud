package com.mht.sprcification.service;

import com.mht.sprcification.bean.GoodSpecification;
import com.mht.sprcification.dao.SpecificationRepo;
import com.mht.util.beanUtils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SpecificationServiceImpl implements ISpecificationService{


    @Autowired
    private SpecificationRepo specificationRepo;

    //保存商品规格
    public ResultInfo save(List<GoodSpecification> list) {
        ArrayList<GoodSpecification> goodSpecifications = new ArrayList<>();
        for (GoodSpecification goodSpecification : list){
            goodSpecification.setId(UUID.randomUUID().toString().replace("-",""));
            goodSpecification.setCreateTime(new Date());
            GoodSpecification save = specificationRepo.save(goodSpecification);
            goodSpecifications.add(save);
        }
        return new ResultInfo(true,goodSpecifications,1);
    }

    @Override
    public ResultInfo findGoodSpecificationBygGoodId(String goodId) {
        List<GoodSpecification> byGoodId = specificationRepo.findByGoodId(goodId);
        return new ResultInfo(true,byGoodId,1);
    }

    @Override
    public void deleteByGoodId(String goodId) {

    }


}
