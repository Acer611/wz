package com.swtl.wz.entity.po.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户工作经历信息
 */
@Data
public class UserWorkExperience implements Serializable{

    @ApiModelProperty(value = "主键")
     private Long id;
    @ApiModelProperty(value = "用户ID")
     private Long userId;
    @ApiModelProperty(value = "职位")
     private String title;
    @ApiModelProperty(value = "入职时间")
     private Date startTime;
    @ApiModelProperty(value = "离职时间")
     private Date endTime;
    @ApiModelProperty(value = "公司名称")
     private String company;
    @ApiModelProperty(value = "工作年限")
     private String workTime;
    @ApiModelProperty(value = "工作内容")
     private String workContent;
    @ApiModelProperty(value = "创建时间")
     private Date createTime;
    @ApiModelProperty(value = "修改时间")
     private Date updatetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
