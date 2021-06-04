package com.usian.feign;

import com.jiyun.vo.ItemContentVo;
import com.usian.pojo.TbContentCategory;
import com.usian.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "usian-content-service")
public interface ContentFeign {

    /*
     * 内容分类管理查询接口
     * */
    @RequestMapping("/content/selectContentCategoryByParentId")
    public List<TbContentCategory> selectContentCategoryByParentId(@RequestParam(name = "id") Long id);

    /*
     * 内容分类管理添加接口
     * */
    @RequestMapping("/content/insertContentCategory")
    public void insertContentCategory(@RequestParam Long parentId,@RequestParam String name);

    /*
     * 内容分类管理删除接口
     * */
    @RequestMapping("/content/deleteContentCategoryById")
    public Result deleteContentCategoryById(@RequestParam Long categoryId);

    /*
     * 内容分类管理修改接口
     * */
    @RequestMapping("/content/updateContentCategory")
    void updateContentCategory(@RequestParam(name = "id") Long id,@RequestParam(name = "name") String name);

    /*
     * 首页大广告位接口
     * */
    @RequestMapping("/content/selectFrontendContentByAD")
    List<ItemContentVo> selectFrontendContentByAD();
}
