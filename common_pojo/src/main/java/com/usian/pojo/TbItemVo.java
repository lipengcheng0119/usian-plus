package com.usian.pojo;

import javax.persistence.Column;

public class TbItemVo extends TbItem {
    private String desc;

    private String itemParams;

    private String param_data;

    @Column(name = "param_data")
    private String paramData;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getItemParams() {
        return itemParams;
    }

    public void setItemParams(String itemParams) {
        this.itemParams = itemParams;
    }
}
