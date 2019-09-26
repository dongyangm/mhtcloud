package com.mht.goods.service;

import com.mht.goods.bean.Good;
import com.mht.util.beanUtils.ResultInfo;

public interface IGoodService {

    public ResultInfo save(Good good);

    public ResultInfo findById(String id);

    public ResultInfo findMyGoods(String id, int pageNum, int pageSize);

    public ResultInfo findByPage(int pageIndex, int pageSIze, String condition);

    public ResultInfo deleteById(String id);

}
