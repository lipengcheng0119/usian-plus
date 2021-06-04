package com.usian.controller;

import com.jiyun.vo.ItemContentVo;
import com.usian.feign.ContentFeign;
import com.usian.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/frontend/content")
public class ContentController {

    @Autowired
    private ContentFeign contentFeign;

    /*
    * 首页大广告位接口
    * */
    @RequestMapping("/selectFrontendContentByAD")
    private Result selectFrontendContentByAD(){
        List<ItemContentVo> itemContentVos =  contentFeign.selectFrontendContentByAD();
        return Result.ok(itemContentVos);
    }
}
