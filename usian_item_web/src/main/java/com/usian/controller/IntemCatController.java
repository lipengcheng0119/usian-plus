package com.usian.controller;


import com.usian.feign.ItemFeign;
import com.usian.pojo.TbItemCat;

import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/backend/itemCategory")
public class IntemCatController {


    @Autowired
    private ItemFeign itemFeign;

    /*
    * 查询商品类目接口
    * */
    @RequestMapping("/selectItemCategoryByParentId")
    public Result selectItemCategoryByParentId(@RequestParam(name = "id",defaultValue = "0") Long id){
        try {
            List<TbItemCat> tbItemCats = itemFeign.selectItemCategoryByParentId(id);
            return Result.ok(tbItemCats);
        } catch (Exception e) {
            return Result.error("×");
        }
    }

}
