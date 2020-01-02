package com.swtl.wz.entity.po.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 配置工作分类（简单上手，在家 躺赚，轻松兼职，极速可做）
 */

@Data
public class ConfigJobCategory implements Serializable{

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "职位分类名称")
    private String jobCategory;
    @ApiModelProperty(value = "状态 0 为删除  1 已删除")
    private Integer status;
    @ApiModelProperty(value = "类型 0 分类名称  1 活动链接")
    private Integer type;
    @ApiModelProperty(value = "图标地址")
    private String icon;
    @ApiModelProperty(value = "活动地址")
    private String url;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
