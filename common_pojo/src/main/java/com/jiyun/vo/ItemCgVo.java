package com.jiyun.vo;


import java.util.List;

public class ItemCgVo {

    private List<Object> data;  //存储的为 n i  存储完毕以后再把自己存入到 Result这个实体类里面 然后返回给页面

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
