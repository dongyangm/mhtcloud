package com.mht.goods;

import com.mht.goods.bean.Good;
import com.mht.goods.service.IGoodService;
import com.mht.util.beanUtils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private IGoodService goodService;

    /**
     * 保存或更新商品
     * @param good
     * @return
     */
    @PostMapping("/save")
    public ResultInfo save (@RequestBody Good good){

        return goodService.save(good);

    }

    /**
     * 根据商品id查询详情
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public ResultInfo findById(@PathVariable String id){

        return goodService.findById(id);

    }

    /**
     * 分页查询我的商品
     * @param id
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/findMyGoods/{id}/{pageNum}/{pageSize}")
    public ResultInfo findMyGoods(@PathVariable("id") String id,
                                  @PathVariable("pageNum") int pageNum,
                                  @PathVariable int pageSize){
        return goodService.findMyGoods(id, pageNum, pageSize);
    }

    /**
     * 分页条件查询
     * @param pageIndex
     * @param pageSIze
     * @param condition
     * @return
     */
    @GetMapping("/findByPage/{pageIndex}/{pageSize}")
    public ResultInfo findByPage(@PathVariable(name = "pageIndex") int pageIndex,
                                 @PathVariable(name = "pageSize") int pageSIze, String condition){
      /*  条件查询：
            viewNum：浏览量
            level：产品优先级
            createTime：创建时间
     */
        return goodService.findByPage(pageIndex, pageSIze, condition);
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @GetMapping("/deleteById/{id}")
    public ResultInfo deleteById(@PathVariable(name = "id") String id){

        return goodService.deleteById(id);

    }

}
