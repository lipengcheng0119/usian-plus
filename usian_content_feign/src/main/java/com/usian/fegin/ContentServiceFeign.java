package com.usian.fegin;

import com.usian.pojo.TbContent;
import com.usian.pojo.TbContentCategory;
import com.usian.utils.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = "usian-content-service")
public interface ContentServiceFeign {

    @PostMapping("/service/content/selectContentCategoryByParentId")
    List<TbContentCategory> selectContentCategoryByParentId(@RequestParam("parentId") Long parentId);

    @PostMapping("/service/content/insertContentCategory")
    void insertContentCategory(@RequestParam("parentId") Long parentId,@RequestParam("name")  String name);

    @PostMapping("/service/content/deleteContentCategoryById")
    public Integer deleteContentCategoryById(@RequestParam("categoryId") Long categoryId);
    @PostMapping("/service/content/updateContentCategory")
    void updateContentCategory(@RequestParam("id") Long id, @RequestParam("name") String name);

    @PostMapping("/service/content/selectTbContentAllByCategoryId")
    PageResult selectTbContentAllByCategoryId(@RequestParam Integer page,
                                              @RequestParam Integer rows,
                                              @RequestParam Long categoryId);

    @PostMapping("/service/content/insertTbContent")
    Integer insertTbContent(TbContent tbContent);

    @RequestMapping("/service/content/deleteContentByIds")
    Integer deleteContentByIds(@RequestParam("id") Long id);
}


