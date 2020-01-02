package com.swtl.wz.entity.vo.response.version;

import com.swtl.wz.entity.po.version.VersionEntity;
import com.swtl.wz.entity.vo.response.CommonResponse;
import io.swagger.annotations.ApiModelProperty;

/**
 * 版本结果返回实体
 */
public class VersionResponse extends CommonResponse {

    @ApiModelProperty(value = "是否强制更新")
    private Boolean isCompel;
    @ApiModelProperty(value = "版本信息实体")
    private VersionEntity versionEntity;

    public Boolean getCompel() {
        return isCompel;
    }

    public void setCompel(Boolean compel) {
        isCompel = compel;
    }

    public VersionEntity getVersionEntity() {
        return versionEntity;
    }

    public void setVersionEntity(VersionEntity versionEntity) {
        this.versionEntity = versionEntity;
    }
}
