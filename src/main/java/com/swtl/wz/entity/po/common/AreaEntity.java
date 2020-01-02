package com.swtl.wz.entity.po.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 区县信息实体
 */
@Data
public class AreaEntity {

    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "区县名称")
    private String areaName;
    @ApiModelProperty(value = "区县ID")
    private Long areaId;
    @ApiModelProperty(value = "所属市的ID")
    private Long townId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getTownId() {
        return townId;
    }

    public void setTownId(Long townId) {
        this.townId = townId;
    }
}
