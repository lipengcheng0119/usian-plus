package com.usian.controller;


import com.usian.fegin.ContentServiceFeign;
import com.usian.pojo.TbContent;
import com.usian.pojo.TbContentCategory;
import com.usian.utils.PageResult;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/backend/content")
public class ContentController {


    @Autowired
    private ContentServiceFeign contentServiceFeign;

    /*查询类目的方法*/

    @RequestMapping("/selectContentCategoryByParentId")
    public Result selectContentCategoryByParentId(@RequestParam(defaultValue = "0") Long id){
        List<TbContentCategory> list = contentServiceFeign.selectContentCategoryByParentId(id);
        if (list != null && list.size() > 0) {
            return Result.ok(list);
        }
        return Result.error("查无结果");
    }

    @RequestMapping("/insertContentCategory")
    public Result insertContentCategory(Long parentId,String name){
        contentServiceFeign.insertContentCategory(parentId,name);
        return Result.ok("成功了哦");
    }

    @RequestMapping("/deleteContentCategoryById")
    public Result deleteContentCategoryById(Long categoryId){
        Integer status = contentServiceFeign.deleteContentCategoryById(categoryId);
        if(status == 200){
            return Result.ok();
        }
        return Result.error("删除失败");
    }
    @RequestMapping("/updateContentCategory")
    public Result updateContentCategory(Long id,String name){
        contentServiceFeign.updateContentCategory(id,name);
        return Result.ok();
    }

    @RequestMapping("/selectTbContentAllByCategoryId")
    public Result selectTbContentAllByCategoryId(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "30") Integer rows, Long categoryId) {
        PageResult pageResult = contentServiceFeign.selectTbContentAllByCategoryId(
                page, rows, categoryId);
        if (pageResult != null) {
            return Result.ok(pageResult);
        }
        return Result.error("查无结果");
    }
    /**
     * 根据分类添加内容
     */
    @RequestMapping("/insertTbContent")
    public Result insertTbContent(TbContent tbContent) {
        Integer num = contentServiceFeign.insertTbContent(tbContent);
        if (num != null) {
            return Result.ok();
        }
        return Result.error("添加失败");
    }
    /**
     * 删除分类的内容
     */
    @RequestMapping("/deleteContentByIds")
    public Result deleteContentByIds(Long ids) {
        Integer num = contentServiceFeign.deleteContentByIds(ids);
        if (num != null) {
            return Result.ok();
        }
        return Result.error("删除失败");
    }

}

