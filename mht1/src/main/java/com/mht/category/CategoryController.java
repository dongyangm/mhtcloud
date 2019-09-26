package com.mht.category;

import com.mht.category.bean.Category;
import com.mht.category.service.ICategoryServie;
import com.mht.util.beanUtils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryServie categoryServie;

    /**
     * 保存分类
     * @param category
     * @return
     */
    @PostMapping("/saveCategory")
    public ResultInfo save (@RequestBody Category category){

        return categoryServie.save(category);

    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public ResultInfo findById (@PathVariable("id") String id){

        return  categoryServie.findById(id);

    }

    /**
     * 根据父id查询
     * @param
     * @return
     */
    @GetMapping("/findCategoryByParentId")
    public ResultInfo findCategoryByParentId (String parentId){

        return  categoryServie.findCategoryByParentId(parentId);

    }

    /**
     * 分类名称模糊查询
     * @param
     * @return
     */
    @GetMapping("/findCategoryByNameLike")
    public ResultInfo findCategoryByNameLike (String name){

        return  categoryServie.findCategoryByName(name);

    }

    /**
     * 分类名称模糊查询
     * @param
     * @return
     */
    @GetMapping("/deleteById/{id}")
    public ResultInfo deleteById (@PathVariable("id") String id){

        return  categoryServie.deleteById(id);

    }


}
