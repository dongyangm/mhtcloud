package com.mht.express.service;

import com.mht.express.bean.Express;
import com.mht.util.beanUtils.ResultInfo;

public interface IExpressService {

    ResultInfo save(Express express);

    ResultInfo deleteById(String id);

    ResultInfo findAll();
}
