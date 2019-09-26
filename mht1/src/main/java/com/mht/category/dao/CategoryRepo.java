package com.mht.category.dao;

import com.mht.category.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.util.List;

public interface CategoryRepo extends JpaRepository<Category,String>, JpaSpecificationExecutor<Category>, Serializable {

    List<Category> findCategoryByParentId(String parentId);

    List<Category> findCategoryByNameLike(String name);

}
