package com.swtl.wz.entity.vo.response.common;

import com.swtl.wz.entity.po.common.Provoncoal;
import com.swtl.wz.entity.vo.response.CommonResponse;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 省份返回对象
 */
public class ProvincialResponse extends CommonResponse{

    @ApiModelProperty(value = "省份对象信息")
    private List<Provoncoal> provoncoalList;

    public List<Provoncoal> getProvoncoalList() {
        return provoncoalList;
    }

    public void setProvoncoalList(List<Provoncoal> provoncoalList) {
        this.provoncoalList = provoncoalList;
    }
}
