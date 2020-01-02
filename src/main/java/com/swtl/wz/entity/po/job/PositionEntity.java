package com.swtl.wz.entity.po.job;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 职位信息实体
 */
@Data
public class PositionEntity  implements Serializable{

    private static final long serialVersionUID =1L;
    @ApiModelProperty(value = "主键")
     private Long id;
    @ApiModelProperty(value = "'公司ID'")
     private Long companyId;
    @ApiModelProperty(value = "客服ID")
     private Long kfId;
    @ApiModelProperty(value = "职位标题")
     private String title;
    @ApiModelProperty(value = "类型 （长期可做  短期  ）")
     private String type;
    @ApiModelProperty(value = "结算方式（日结，次日接）")
     private String cleanType;
    @ApiModelProperty(value = "'招聘人数'")
     private Integer needPeople;
    @ApiModelProperty(value = "已录取人数")
    private Integer hasPeople;
    @ApiModelProperty(value = "报名人数")
    private Integer reportPeople;
    @ApiModelProperty(value = "薪资")
    private String money;
    @ApiModelProperty(value = "工作要求（兼职  性别）")
    private String jobRequired;
    @ApiModelProperty(value = "任务类型（服务员  收银员 关联jobTitleDetail表的ID ）")
    private Integer taskType;
    @ApiModelProperty(value = "工作流程")
    private String workflow;
    @ApiModelProperty(value = "职位详情")
    private String jobDetail;
    @ApiModelProperty(value = "工作详细地点")
    private String address;
    @ApiModelProperty(value = "位置  关联city 表的id")
    private Integer location;
    @ApiModelProperty(value = "职位标签（ 0  火爆  1 急聘   2  热门）")
    private Integer lable;
    @ApiModelProperty(value = "职位分类  （0 简单  1 躺赚 2 轻松   3 极速）")
    private Integer category;
    @ApiModelProperty(value = "发布时间")
    private Date publishTime;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "所在地展示字段")
    private String locationName;

    @ApiModelProperty(value = "公司名称")
    private String companyName = "";

    @ApiModelProperty(value = "公司是否认证  0 未认证  1 已认证")
    private Integer authentication = 0;

    @ApiModelProperty(value = "报名状态  0 未报名  1 已报名")
    private Integer applyStatus = 0;
    @ApiModelProperty(value = "收藏状态  0 未收藏  1  已收藏")
    private Integer likeStatus = 0;

    @ApiModelProperty(value = "是否是热门推荐  0 不是热门  1  热门")
    private Integer isHot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getKfId() {
        return kfId;
    }

    public void setKfId(Long kfId) {
        this.kfId = kfId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCleanType() {
        return cleanType;
    }

    public void setCleanType(String cleanType) {
        this.cleanType = cleanType;
    }

    public Integer getNeedPeople() {
        return needPeople;
    }

    public void setNeedPeople(Integer needPeople) {
        this.needPeople = needPeople;
    }

    public Integer getHasPeople() {
        return hasPeople;
    }

    public void setHasPeople(Integer hasPeople) {
        this.hasPeople = hasPeople;
    }

    public Integer getReportPeople() {
        return reportPeople;
    }

    public void setReportPeople(Integer reportPeople) {
        this.reportPeople = reportPeople;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getJobRequired() {
        return jobRequired;
    }

    public void setJobRequired(String jobRequired) {
        this.jobRequired = jobRequired;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public String getWorkflow() {
        return workflow;
    }

    public void setWorkflow(String workflow) {
        this.workflow = workflow;
    }

    public String getJobDetail() {
        return jobDetail;
    }

    public void setJobDetail(String jobDetail) {
        this.jobDetail = jobDetail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Integer getLable() {
        return lable;
    }

    public void setLable(Integer lable) {
        this.lable = lable;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Integer authentication) {
        this.authentication = authentication;
    }

    public Integer getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(Integer applyStatus) {
        this.applyStatus = applyStatus;
    }

    public Integer getLikeStatus() {
        return likeStatus;
    }

    public void setLikeStatus(Integer likeStatus) {
        this.likeStatus = likeStatus;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }
}
