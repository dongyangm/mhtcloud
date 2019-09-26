package com.mht.sprcification;

import com.mht.sprcification.bean.GoodSpecification;
import com.mht.sprcification.service.ISpecificationService;
import com.mht.util.beanUtils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goodSpec")
public class GoodSpec {

    @Autowired
    private ISpecificationService specificationService;

    /**
     * 保存商品规格
     * @param list
     * @return
     */
    @PostMapping("/save")
    public ResultInfo save(@RequestBody List<GoodSpecification> list){
        return specificationService.save(list);
    }

    @GetMapping("/findByGoodId/{goodId}")
    public ResultInfo findByGoodId( @PathVariable String goodId){
        return specificationService.findGoodSpecificationBygGoodId(goodId);
    }
}
