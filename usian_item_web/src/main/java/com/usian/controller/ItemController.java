package com.usian.controller;

import com.usian.utils.PageResult;
import com.usian.utils.Result;
import com.usian.fegin.ItemServiceFeign;
import org.springframework.web.bind.annotation.RequestMapping;
import com.usian.pojo.TbItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/backend/item")
public class ItemController {
    @Autowired
    private ItemServiceFeign itemServiceFeign;

    /**
     * 查询商品基本信息
     * /
     */
    @RequestMapping("/selectItemInfo")
    public Result selectItemInfo(Long itemId) {
        TbItem tbItem = itemServiceFeign.selectItemInfo(itemId);
        if (tbItem != null) {
            return Result.ok(tbItem);
        }
        return Result.error("查无结果");
    }
    /**
     * 查询商品并分页处理
     *
     * @return
     */
    @RequestMapping("/selectTbItemAllByPage")
    public Result selectTbItemAllByPage(@RequestParam(defaultValue = "1")
                                                Integer page, @RequestParam(defaultValue = "2") Integer rows) {

        PageResult pageResult = itemServiceFeign.selectTbItemAllByPage(page, rows);
        if (pageResult.getResult() != null) {
            return Result.ok(pageResult);
        }
        return Result.error("查无结果");
    }


    @RequestMapping("/insertTbItem")
    public Result insertTbItem(TbItem tbItem,String desc,String itemParams){
        Integer insertTbItemNum = itemServiceFeign.insertTbItem(tbItem, desc,itemParams);
        if(insertTbItemNum==3){
            return Result.ok();
        }
        return Result.error("添加失败");
    }

    @RequestMapping("/updateTbItem")
    public Result updateTbItem(TbItem tbItem,String desc,String itemParams){
     itemServiceFeign.updateTbItem(tbItem, desc,itemParams);

        return Result.ok();
    }


    /*/backend/item/preUpdateItem*/
    @RequestMapping("/preUpdateItem")
    public Result preUpdateItem(Long itemId){
        Map<String,Object> map = itemServiceFeign.preUpdateItem(itemId);
        if(map.size()>0){
            return Result.ok(map);
        }
        return Result.error("查无结果");
    }

    /*/backend/item/preUpdateItem*/
    @RequestMapping("/deleteItemById")
    public Result deleteItemById(Long itemId){
       itemServiceFeign.deleteItemById(itemId);

      return Result.ok("删除成功");

    }

}