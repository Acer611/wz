package com.swtl.wz.entity.po.article;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 软文的实体信息
 */
@Data
public class ArticleEntity  implements Serializable{

     @ApiModelProperty(value = "唯一标示")
     private Long id;
     @ApiModelProperty(value = "软文标题")
     private String title;
     @ApiModelProperty(value = "软文链接地址")
     private String url;
     @ApiModelProperty(value = "软文内容")
     private String content;
     @ApiModelProperty(value = "软文状态 0 为删除  1 删除")
     private Integer status;
     @ApiModelProperty(value = "软文标签")
     private String label;
     @ApiModelProperty(value = "阅读次数")
     private Integer readTimes;
     @ApiModelProperty(value = "创建时间")
     private Date createTime;
     @ApiModelProperty(value = "软文图片地址")
     private String imgUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getReadTimes() {
        return readTimes;
    }

    public void setReadTimes(Integer readTimes) {
        this.readTimes = readTimes;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
