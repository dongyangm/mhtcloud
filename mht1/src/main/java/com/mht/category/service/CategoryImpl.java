package com.mht.category.service;

import com.mht.category.bean.Category;
import com.mht.category.dao.CategoryRepo;
import com.mht.util.beanUtils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CategoryImpl implements ICategoryServie {

    @Autowired
    private CategoryRepo categorybizc;

    @Transactional
    public ResultInfo save (Category category){
        if(category.getId() == null){
            category.setId(UUID.randomUUID().toString().replace("-",""));
        }
        ResultInfo resultInfo = new ResultInfo(true, categorybizc.save(category), 1);
        return resultInfo;

    }

    public ResultInfo findById (String id){

        return  new ResultInfo(true,categorybizc.findById(id).orElse(null),1);

    }


    public ResultInfo findCategoryByParentId (String parentId){

        return  new ResultInfo(true, categorybizc.findCategoryByParentId(parentId == null? "0" : parentId), 1);

    }

    public ResultInfo findCategoryByName(String name){
        return new ResultInfo(true,categorybizc.findCategoryByNameLike("%"+name+"%"),1);
    }

    public ResultInfo deleteById(String id){

        categorybizc.deleteById(id);
        return new ResultInfo(true,null,1);
    }
}
