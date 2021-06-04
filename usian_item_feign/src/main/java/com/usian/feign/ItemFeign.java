package com.usian.feign;

import com.jiyun.vo.ItemCgVo;
import com.jiyun.vo.ItemContentVo;
import com.usian.pojo.TbItemCat;
import com.usian.pojo.TbItemParam;

import com.usian.pojo.TbItemVo;
import com.usian.utils.PageResult;
import com.usian.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@FeignClient(value = "usian-item-service")
public interface ItemFeign {
    /*
     * 查询商品列表接口
     * */
    @RequestMapping("/item/selectTbItemAllByPage")
    public PageResult selectTbItemAllByPage(@RequestParam(name = "page") Integer page, @RequestParam(name = "rows") Integer rows);


    /*
     * 商品添加接口
     * */
    @RequestMapping("/item/insertTbItem")
    void insertTbItem(@RequestBody TbItemVo tbItemVo);

    /*
     * 删除商品
     * */
    @RequestMapping("/item/deleteItemById")
    void deleteItemById(@RequestParam(name = "deleteItemById") Integer itemId);

    /*
     * 预更新商品接口
     * */
    @RequestMapping("/item/preUpdateItem")
    Map<String, Object> preUpdateItem(@RequestParam(name = "itemId") Integer itemId);

    /*
     * 修改商品信息接口
     * */
    @RequestMapping("/item/updateTbItem")
    void updateTbItem(@RequestBody TbItemVo tbItemVo);

    /*
     * 查询商品类目接口
     * */
    @RequestMapping("/itemCat/selectItemCategoryByParentId")
    public List<TbItemCat> selectItemCategoryByParentId(@RequestParam("id") Long id);

    /*
     * 查询商品规格参数模板接口
     * */
    @RequestMapping("/itemParam/selectItemParamByItemCatId/{itemCatId}")
    public TbItemParam selectItemParamByItemCatId(@PathVariable("itemCatId") Long itemCatId);

    /*
     * 规格模板查询接口
     * */
    @RequestMapping("/itemParam/selectItemParamAll")
    public PageResult selectItemParamAll(@RequestParam(name = "page") Integer page,@RequestParam(name = "rows") Integer rows);

    /*
     * 商品规格模板添加接口
     * */
    @RequestMapping("/itemParam/insertItemParam")
    void insertItemParam(@RequestParam(name = "itemCatId") Long itemCatId, @RequestParam(name = "paramData") String paramData);

    /*
     * 商品规格模板删除接口
     * */
    @RequestMapping("/itemParam/deleteItemParamById")
    void deleteItemParamById(@RequestParam(name = "id") Long id);

    /*
     *  首页左侧商品分类接口
     * */
    @RequestMapping("/itemCat/selectItemCategoryAll")
    ItemCgVo selectItemCategoryAll();

}
