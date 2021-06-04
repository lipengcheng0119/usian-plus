package com.usian.fegin;




import com.usian.pojo.TbItem;
import com.usian.pojo.TbItemCat;
import com.usian.pojo.TbItemParam;
import com.usian.utils.PageResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.Map;

@FeignClient(value = "usian-item-service")
public interface ItemServiceFeign {

    @RequestMapping("/service/item/selectItemInfo")
    TbItem selectItemInfo(@RequestParam("itemId") Long itemId);


    @GetMapping("/service/item/selectTbItemAllByPage")
    PageResult selectTbItemAllByPage(@RequestParam Integer page,
                                     @RequestParam Integer rows);


    @PostMapping("/service/itemCategory/selectItemCategoryByParentId")
    List<TbItemCat> selectItemCategoryByParentId(@RequestParam("id") Long id);

    @PostMapping("/service/itemParam/selectItemParamByItemCatId")
    TbItemParam selectItemParamByItemCatId(@RequestParam("itemCatId") Long itemCatId);

    @GetMapping("/service/item/insertTbItem")
    public Integer insertTbItem(@RequestBody TbItem tbItem, @RequestParam String desc,
                                @RequestParam String itemParams);

    @RequestMapping("/service/item/preUpdateItem")
    Map<String,Object> preUpdateItem(@RequestParam("itemId") Long itemId);


    @GetMapping("/service/item/updateTbItem")
    public void updateTbItem(@RequestBody TbItem tbItem, @RequestParam String desc,
                                @RequestParam String itemParams);

    @PostMapping("/service/item/deleteItemById")
    void deleteItemById(@RequestParam("itemId") Long itemId);

    @GetMapping("/service/itemParam/selectItemParamAll")
    PageResult selectItemParamAll(@RequestParam Integer page,
                                  @RequestParam Integer rows);

    @RequestMapping("/service/itemParam/insertItemParam")
    Integer insertItemParam(@RequestParam Long itemCatId,
                            @RequestParam String paramData);

    @GetMapping("/service/itemParam/deleteItemParamById")
    void deleteItemParamById(@RequestParam("id") Long id);
}
