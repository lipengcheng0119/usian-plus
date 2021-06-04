package com.usian.service.impl;

import com.jiyun.vo.ItemCgSon;
import com.jiyun.vo.ItemCgVo;
import com.usian.mapper.TbItemCatMapper;
import com.usian.pojo.TbItemCat;
import com.usian.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
     private TbItemCatMapper tbItemCatMapper;

    /*
     * 查询商品类目接口
     * */
    @Override
    public List<TbItemCat> selectItemCategoryByParentId(Long id) {
        TbItemCat tbItemCat = new TbItemCat();
        tbItemCat.setParentId(id);
        return tbItemCatMapper.select(tbItemCat);
    }


    /*
     *  首页左侧商品分类接口
     * */
    @Override
    public ItemCgVo selectItemCategoryAll() {
        ItemCgVo itemCgVo =new ItemCgVo();
        itemCgVo.setData(findItemCategoryAll(0L));
        return itemCgVo;
    }

    public List findItemCategoryAll(Long parentid){
        /**
         * 根据父ID查询所有信息
         * */
        List  list  = new ArrayList<>();

        TbItemCat tbItemCat = new TbItemCat();
        tbItemCat.setParentId(parentid);
        //查询出来所有的一级标签内容
        List<TbItemCat> Tb = tbItemCatMapper.select(tbItemCat);

        //遍历查询结果
        for (TbItemCat itemCat : Tb) {
            //itemCat为某一个分类
            if (!itemCat.getIsParent()){
                //如果该分类下面没有其他的子分类  直接添加到创建的list集合当中
                list.add(itemCat.getName());
            }else{
                //如果下面还有其子分类
                //创建一个空对象 用于存放子节点
                ItemCgSon son = new ItemCgSon();
                //调用自己的方法  进行再一次查询
                List itemCategoryAll = findItemCategoryAll(itemCat.getId());
                //讲该节点的名称存入到  ItemCgSon 实体类中  为 N
                son.setN(itemCat.getName());
                //讲查询到的数据添加到  ItemCgSon 实体类中 为  I
                son.setI(itemCategoryAll);
                //把查询得到的东西添加到list集合当中
                list.add(son);
            }
        }
        //list 集合存放的可能是 ItemCgSon实体类  也可能是  String类型的节点的名称
        return list;
    }
}
