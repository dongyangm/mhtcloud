package com.mht.express;

import com.mht.express.bean.Express;
import com.mht.express.service.IExpressService;
import com.mht.util.beanUtils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/express")
public class ExpressController {

    @Autowired
    private IExpressService expressService;

    @PostMapping("/save")
    public ResultInfo save(@RequestBody Express express){
        return expressService.save(express);
    }

    @GetMapping("/deleteById/{id}")
    public ResultInfo deleteById(@PathVariable String id){
        return expressService.deleteById(id);
    }

    @GetMapping("/findAll")
    public ResultInfo findAll(){
        return expressService.findAll();
    }

}
