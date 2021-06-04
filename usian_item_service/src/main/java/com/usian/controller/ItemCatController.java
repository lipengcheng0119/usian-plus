package com.usian.controller;

import com.jiyun.vo.ItemCgVo;
import com.usian.pojo.TbItemCat;
import com.usian.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/itemCat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    /*
     * 查询商品类目接口
     * */
    @RequestMapping("/selectItemCategoryByParentId")
    public List<TbItemCat> selectItemCategoryByParentId(@RequestParam("id") Long id){
        return itemCatService.selectItemCategoryByParentId(id);
    }

    /*
     *  首页左侧商品分类接口
     * */
    @RequestMapping("/selectItemCategoryAll")
    ItemCgVo selectItemCategoryAll(){
        return itemCatService.selectItemCategoryAll();
    }

}
