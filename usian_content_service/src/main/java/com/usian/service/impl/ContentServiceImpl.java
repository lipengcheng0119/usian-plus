package com.usian.service.impl;

import com.jiyun.vo.ItemContentVo;
import com.usian.mapper.TbContentMapper;
import com.usian.pojo.TbContent;
import com.usian.pojo.TbContentCategory;
import com.usian.service.ContentService;
import com.variable.ContentVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper tbContentMapper;

    /*
     * 首页大广告位接口
     * */
    @Override
    public List<ItemContentVo> selectFrontendContentByAD() {
        List<ItemContentVo>  list = new ArrayList<>();
        List<TbContent> tbContents = tbContentMapper.SelectByBig(ContentVariable.BIGID);
        for (TbContent tbContent : tbContents) {
            ItemContentVo itemContentVo=new ItemContentVo();
            itemContentVo.setHref(tbContent.getUrl());
            itemContentVo.setSrc(tbContent.getPic());
            itemContentVo.setSrcB(null);
            itemContentVo.setAlt("啦啦啦");
            itemContentVo.setHeight(ContentVariable.CONTENT_HEIGHT);
            itemContentVo.setHeightB(ContentVariable.CONTENT_HEIGHTB);
            itemContentVo.setWidth(ContentVariable.CONTENT_WIDTH);
            itemContentVo.setWidthB(ContentVariable.CONTENT_WIDTHB);
            list.add(itemContentVo);
        }
        return list;
    }
}
