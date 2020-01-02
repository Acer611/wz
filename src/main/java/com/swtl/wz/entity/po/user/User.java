package com.swtl.wz.entity.po.user;


import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 用户实体类
 */
@Data
public class User implements Serializable {

    /** 主键 */
    @ApiModelProperty(value="ID")
    private Long id;
    /** 手机号 */
    @ApiModelProperty(value="手机号")
    private String mobile;
    /** 密码 */
    @ApiModelProperty(value="密码")
    private String password;
    /** 昵称 */
    @ApiModelProperty(value="昵称")
    private String name;
    /** 头像 */
    @ApiModelProperty(value="头像")
    private String faceUrl;
    /** 账户余额*/
    @ApiModelProperty(value="账户余额")
    private BigDecimal balance;
    /** 性别 */
    @ApiModelProperty(value=" 性别 0 男 1  女   2  保密 3 未知")
    private Integer sex;
    /** 学历 */
    @ApiModelProperty(value="学历")
    private String education;
    /** 出生年分 */
    @ApiModelProperty(value="出生年分")
    private String birthyear;
    /** 出生年月 */
    @ApiModelProperty(value="出生年月日")
    private String birthday;
    /** 身份  0 学生  1  非学生 */
    @ApiModelProperty(value="身份  0 学生  1  非学生 2 未知")
    private Integer identity;

    /** 是否有健康证 */
    @ApiModelProperty(value="是否有健康证  0 没有  1  有")
    private Integer isHealth;
    /** 身高 */
    @ApiModelProperty(value="身高")
    private Double height;
    /** 体重 */
    @ApiModelProperty(value="体重")
    private Double weight;
    /** 居住地点 */
    @ApiModelProperty(value="居住地点")
    private String address;
    /** 微信 */
    @ApiModelProperty(value="微信")
    private String wechat;
    /** QQ */
    @ApiModelProperty(value="QQ")
    private String qq;
    /** 邮箱 */
    @ApiModelProperty(value="邮箱")
    private String mail;
    /** 自我介绍 */
    @ApiModelProperty(value="自我介绍")
    private String descrption;
    /** 个人照片 */
    @ApiModelProperty(value="个人照片")
    private String photo;
    /** 真是姓名 */
    @ApiModelProperty(value="真是姓名")
    private String relaName;
    /** 身份证号 */
    @ApiModelProperty(value="身份证号")
    private String id_card;
    /** 简历完成进度 */
    @ApiModelProperty(value="简历完成进度")
    private String schedule;
    /** 创建时间 */
    @ApiModelProperty(value="创建时间")
    private Date createTime;
    /** 渠道号 */
    @ApiModelProperty(value="渠道号")
    private String channel;
    /** 修改时间 */
    @ApiModelProperty(value="修改时间")
    private Date updateTime;

    @ApiModelProperty(value="教育信息集合")
    private List<UserEducation> userEducationList;

    @ApiModelProperty(value="工作信息集合")
    private List<UserWorkExperience> userWorkExperienceList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRelaName() {
        return relaName;
    }

    public void setRelaName(String relaName) {
        this.relaName = relaName;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(String birthyear) {
        this.birthyear = birthyear;
    }

    public List<UserEducation> getUserEducationList() {
        return userEducationList;
    }

    public void setUserEducationList(List<UserEducation> userEducationList) {
        this.userEducationList = userEducationList;
    }

    public List<UserWorkExperience> getUserWorkExperienceList() {
        return userWorkExperienceList;
    }

    public void setUserWorkExperienceList(List<UserWorkExperience> userWorkExperienceList) {
        this.userWorkExperienceList = userWorkExperienceList;
    }

    public Integer getIsHealth() {
        return isHealth;
    }

    public void setIsHealth(Integer isHealth) {
        this.isHealth = isHealth;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
