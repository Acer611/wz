package com.swtl.wz.entity.po.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 职位Labelb标签  (热门  急聘  火爆)
 */
@Data
public class ConfigJobLabel implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "职位label")
    private String lable;
    @ApiModelProperty(value = "状态 0 为删除  1 已删除")
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
