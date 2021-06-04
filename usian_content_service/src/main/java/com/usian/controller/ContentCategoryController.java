package com.usian.controller;

import com.usian.pojo.TbContent;
import com.usian.pojo.TbContentCategory;
import com.usian.service.ContentCategoryService;
import com.usian.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service/content")
public class ContentCategoryController {
    @Autowired
    private ContentCategoryService contentCategoryService;

    /**
     * 根据父节点 ID 查询子节点
     */
    /**
     * 根据父节点 ID 查询子节点
     */
    @RequestMapping("/selectContentCategoryByParentId")
    public List<TbContentCategory>
    selectContentCategoryByParentId(Long parentId) {
        return this.contentCategoryService.selectContentCategoryByParentId(parentId);
    }


    @RequestMapping("insertContentCategory")
    void insertContentCategory(Long parentId,String name){
        contentCategoryService.insertContentCategory(parentId,name);
    }



    /**
     * 删除内容分类
     */
    @RequestMapping("/deleteContentCategoryById")
    public Integer deleteContentCategoryById(Long categoryId){
        return this.contentCategoryService.deleteContentCategoryById(categoryId);
    }
    @RequestMapping("/updateContentCategory")
    void updateContentCategory(Long id,String name){
        this.contentCategoryService.updateContentCategory(id,name);
    }
        /**
         * 根据分类查询内容
         */
        @RequestMapping("/selectTbContentAllByCategoryId")
        public PageResult selectTbContentAllByCategoryId(Integer page, Integer rows, Long categoryId) {
            return this.contentCategoryService.selectTbContentAllByCategoryId(page, rows, categoryId);
}
    /**
     * 根据分类添加内容
     */
    @RequestMapping("/insertTbContent")
    public Integer insertTbContent(@RequestBody TbContent tbContent){
        return this.contentCategoryService.insertTbContent(tbContent);
    }
    /**
     * 删除分类下的内容
     */
    @RequestMapping("/deleteContentByIds")
    public Integer deleteContentByIds(@RequestParam Long id){
        return this.contentCategoryService.deleteContentByIds(id);
    }
}