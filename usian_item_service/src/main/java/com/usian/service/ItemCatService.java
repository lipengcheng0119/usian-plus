package com.usian.service;

import com.jiyun.vo.ItemCgVo;
import com.usian.pojo.TbItemCat;

import java.util.List;

public interface ItemCatService {


    /*
     * 查询商品类目接口
     * */
    List<TbItemCat> selectItemCategoryByParentId(Long id);

    /*
     *  首页左侧商品分类接口
     * */
   ItemCgVo  selectItemCategoryAll();


}
