package com.mht.express.service;

import com.mht.express.dao.IExpressRepo;
import com.mht.express.bean.Express;
import com.mht.util.beanUtils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class ExpressServiceImpl implements IExpressService {

    @Autowired
    private IExpressRepo expressRepo;

    @Transactional
    public ResultInfo save(Express express){

        if (express.getId() == null){
            express.setId(UUID.randomUUID().toString().replace("-",""));
        }
        Express save = expressRepo.save(express);

        return new ResultInfo(true,expressRepo.save(express),1);

    }

    @Transactional
    public  ResultInfo deleteById(String id){
        expressRepo.deleteById(id);
        return new ResultInfo(true,"",1);
    }

    @Override
    public ResultInfo findAll() {
        return new ResultInfo(true,expressRepo.findAll(),1);
    }
}
