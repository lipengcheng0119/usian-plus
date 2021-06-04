package com.jiyun.vo;

import java.util.List;

public class ItemCgSon {

    private String n;  //分类的名称
    private List i;    //分类名称下面的子分类

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public List getI() {
        return i;
    }

    public void setI(List i) {
        this.i = i;
    }
}
