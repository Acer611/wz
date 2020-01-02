package com.swtl.wz.entity.vo.response.common;

import com.swtl.wz.entity.po.common.AreaEntity;
import com.swtl.wz.entity.vo.response.CommonResponse;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 区县返回对象
 */
public class AreasResponse extends CommonResponse {

    @ApiModelProperty(value = "区县信息集合")
    private List<AreaEntity> areaEntity;

    public List<AreaEntity> getAreaEntity() {
        return areaEntity;
    }

    public void setAreaEntity(List<AreaEntity> areaEntity) {
        this.areaEntity = areaEntity;
    }
}
