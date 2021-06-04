package com.usian.controller;


import com.jiyun.vo.ItemContentVo;
import com.usian.pojo.TbContentCategory;
import com.usian.service.ContentCategoryService;
import com.usian.service.ContentService;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ContentServiceController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @Autowired
    private ContentService contentService;

    /*
     * 内容分类管理查询接口
     * */
    @RequestMapping("/content/selectContentCategoryByParentId")
    public List<TbContentCategory> selectContentCategoryByParentId(@RequestParam(name = "id") Long id){
        return contentCategoryService.selectContentCategoryByParentId(id);
    }

    /*
     * 内容分类管理添加接口
     * */
    @RequestMapping("/content/insertContentCategory")
    public void insertContentCategory(@RequestParam Long parentId, @RequestParam String name){
        contentCategoryService.insertContentCategory(parentId,name);

    }

    /*
     * 内容分类管理删除接口
     * */
    @RequestMapping("/content/deleteContentCategoryById")
    public void deleteContentCategoryById(Long categoryId){
        contentCategoryService.deleteContentCategoryById(categoryId);
    }

    /*
     * 内容分类管理修改接口
     * */
    @RequestMapping("/content/updateContentCategory")
    void updateContentCategory(Long id, String name){
        contentCategoryService.updateContentCategory(id,name);
    }

    /*
     * 首页大广告位接口
     * */
    @RequestMapping("/content/selectFrontendContentByAD")
    List<ItemContentVo> selectFrontendContentByAD(){
        return contentService.selectFrontendContentByAD();
    }

}
