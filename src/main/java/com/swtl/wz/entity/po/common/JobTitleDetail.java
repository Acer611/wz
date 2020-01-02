package com.swtl.wz.entity.po.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class JobTitleDetail implements Serializable {

    private static final long serialVersionUID =1L;
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "关联 jobTile的id")
    private Long pid;
    @ApiModelProperty(value = "职位名称")
    private String name;
    @ApiModelProperty(value = "状态 0 为删除  1 已删除")
    private Integer status;

    @ApiModelProperty(value = "职位分类筛选时传参ID")
    private Long classificationId;
    @ApiModelProperty(value = "职位描述")
    private String classifyDesc;
    @ApiModelProperty(value = "上一级的classID")
    private String parentId;
    @ApiModelProperty(value = "等级")
    private Integer classLevel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(Long classificationId) {
        this.classificationId = classificationId;
    }

    public String getClassifyDesc() {
        return classifyDesc;
    }

    public void setClassifyDesc(String classifyDesc) {
        this.classifyDesc = classifyDesc;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(Integer classLevel) {
        this.classLevel = classLevel;
    }
}
