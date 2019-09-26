package com.mht.goods.service;

import com.mht.goods.bean.Good;
import com.mht.goods.dao.GoodRepo;
import com.mht.sprcification.service.ISpecificationService;
import com.mht.util.beanUtils.PageInfo;
import com.mht.util.beanUtils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class GoodServiceImpl implements IGoodService{

    @Autowired
    private GoodRepo goodService;

    @Autowired
    private ISpecificationService specificationService;


    public ResultInfo save (Good good){
        good.setId(UUID.randomUUID().toString().replace("-",""));
        good.setViewNum(0);
        good.setCreateTime(new Date());
        good.setLevel(1);
        good.setSoldNum(0);
        Good save = goodService.save(good);
        return new ResultInfo(true,save,1);
    }


    public ResultInfo findById(@PathVariable String id){
        Optional<Good> byId = goodService.findById(id);
        Good good = byId.orElse(null);
        if (good != null ){
            good.setViewNum(good.getViewNum()+1);
            goodService.updateViewNum(id,good.getViewNum());
        }
        return new ResultInfo(true,good,1);
    }

    public ResultInfo findMyGoods(String id, int pageNum, int pageSize){
        Page<Good> myGoods = goodService.findMyGoods(id, new PageRequest(pageNum - 1, pageSize));
        PageInfo pageInfo = new PageInfo(pageNum, pageSize, (int) myGoods.getTotalPages(), myGoods.getContent());
        return new ResultInfo(true,pageInfo,1);
    }

    public ResultInfo findByPage(int pageIndex, int pageSIze, String condition){
      /*  条件查询：
            viewNum：浏览量
            level：产品优先级
            createTime：创建时间
     */
        Sort sort = new Sort(Sort.Direction.DESC, condition);
        Page<Good> all = goodService.findAll(new PageRequest(pageIndex - 1, pageSIze,sort));
        int totalPages = all.getTotalPages();
        PageInfo pageInfo = new PageInfo(pageIndex,pageSIze,totalPages,all.getContent());
        return new ResultInfo(true,pageInfo,1);
    }

    public ResultInfo deleteById(String id){
           goodService.deleteById(id);
           //删除商品规格
           specificationService.deleteByGoodId(id);
        return new ResultInfo(true,null,1);
    }
}
