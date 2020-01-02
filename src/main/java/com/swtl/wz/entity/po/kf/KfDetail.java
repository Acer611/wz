package com.swtl.wz.entity.po.kf;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class KfDetail implements Serializable {

    @ApiModelProperty(value = "主键")
    private  Long id;
    @ApiModelProperty(value = "客服配置表的ID   关联 t_kf_config表的ID")
    private Long confId;
    @ApiModelProperty(value = "'qq'")
    private String qq;
    @ApiModelProperty(value = "微信")
    private String wechat;
    @ApiModelProperty(value = "支付宝")
    private String aliPay;
    @ApiModelProperty(value = "客服名称")
    private String name;
    @ApiModelProperty(value = "客服URL")
    private String url;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConfId() {
        return confId;
    }

    public void setConfId(Long confId) {
        this.confId = confId;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getAliPay() {
        return aliPay;
    }

    public void setAliPay(String aliPay) {
        this.aliPay = aliPay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
