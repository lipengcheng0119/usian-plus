package com.usian.controller;


import com.jiyun.vo.ItemCgVo;
import com.usian.feign.ItemFeign;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/frontend/itemCategory")
public class ItemCategoryController {

    @Autowired
    private ItemFeign itemFeign;

    /*
    *  首页左侧商品分类接口
    * */
    @RequestMapping("/selectItemCategoryAll")
    public Result selectItemCategoryAll(){
        ItemCgVo itemCgVo = itemFeign.selectItemCategoryAll();
        return Result.ok(itemCgVo);

    }
}
