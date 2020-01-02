package com.swtl.wz.entity.po.message;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息的实体对象
 */
@Data
public class MessageEntity implements Serializable {

    @ApiModelProperty(value = "主键")
    private Long id;
    @ApiModelProperty(value = "消息类型  0  系统消息  1 其他消息")
    private Integer type;
    @ApiModelProperty(value = "消息标题")
    private String title;
    @ApiModelProperty(value = "消息内容")
    private String content;
    @ApiModelProperty(value = "消息状态 （0  未读  1 已读）")
    private Integer status;
    @ApiModelProperty(value = " 用户ID 关联t_user 表的id  " )
    private Long  userId;
    @ApiModelProperty(value = " 创建时间 " )
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
