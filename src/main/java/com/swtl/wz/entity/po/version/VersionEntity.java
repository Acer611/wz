package com.swtl.wz.entity.po.version;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 版本信息
 */
@Data
public class VersionEntity implements Serializable {

    /** 主键 */
    @ApiModelProperty(value = "主键")
    private Long id;
    /** 类型  1 iso  2 android */
    @ApiModelProperty(value = "类型  1 iso  2 android")
    private Long type;
    /** 最新的版本 */
    @ApiModelProperty(value = "最新的版本")
    private String newVersion;
    /** 最低使用版本 */
    @ApiModelProperty(value = "最低使用版本")
    private String lastVersion;
    /** 更新内容 */
    @ApiModelProperty(value = "更新内容")
    private String content;
    /** 更新链接 */
    @ApiModelProperty(value = "更新链接")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public String getNewVersion() {
        return newVersion;
    }

    public void setNewVersion(String newVersion) {
        this.newVersion = newVersion;
    }

    public String getLastVersion() {
        return lastVersion;
    }

    public void setLastVersion(String lastVersion) {
        this.lastVersion = lastVersion;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
