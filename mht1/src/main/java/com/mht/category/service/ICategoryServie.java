package com.mht.category.service;

import com.mht.category.bean.Category;
import com.mht.util.beanUtils.ResultInfo;


public interface ICategoryServie {

    public ResultInfo save(Category category);

    public ResultInfo findById(String id);

    public ResultInfo findCategoryByParentId(String parentId);

    public ResultInfo findCategoryByName(String name);

    public ResultInfo deleteById(String id);
}
