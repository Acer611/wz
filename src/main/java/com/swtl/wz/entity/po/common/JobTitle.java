package com.swtl.wz.entity.po.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 职位分类表
 */
@Data
public class JobTitle implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "职位分类名称")
    private String title;
    @ApiModelProperty(value = "状态 0 为删除  1 已删除")
    private Integer status;

    @ApiModelProperty(value = "筛选传参用的ID")
    private Long classId;
    @ApiModelProperty(value = "职位描述")
    private String classDesc;
    @ApiModelProperty(value = "等级")
    private String classLevel;


    @ApiModelProperty(value = "二级职业信息")
    private List<JobTitleDetail> jobTitleDetailList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

    public String getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(String classLevel) {
        this.classLevel = classLevel;
    }

    public List<JobTitleDetail> getJobTitleDetailList() {
        return jobTitleDetailList;
    }

    public void setJobTitleDetailList(List<JobTitleDetail> jobTitleDetailList) {
        this.jobTitleDetailList = jobTitleDetailList;
    }
}
