package com.mht.interecord.service;

import com.mht.util.beanUtils.ResultInfo;

public interface IIntegralRecodService {

    public ResultInfo businessFindMyIntegralRecord(String businessId, int pageNum, int pagesize);

    public ResultInfo businessFindBuyerGroup(String businessId, int pageNum, int pageSize);

    public ResultInfo businessFindRecord(String businessId, String userId, int pageNum, int pageSize);

    public ResultInfo buyerFindAllIntegralRecord(String userId, int pageNum, int pagesize);

    public ResultInfo buyerFindBusinessGroup(String userId, int pageNum, int pageSize);

    public ResultInfo deleteById(String id);
}
