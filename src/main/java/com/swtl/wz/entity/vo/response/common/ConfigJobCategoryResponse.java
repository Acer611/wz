package com.swtl.wz.entity.vo.response.common;

import com.swtl.wz.entity.po.common.ConfigJobCategory;
import com.swtl.wz.entity.vo.response.CommonResponse;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


/**
 * 职业分类的返回对象
 */
public class ConfigJobCategoryResponse extends CommonResponse {

    @ApiModelProperty("职业分类信息集合")
    private List<ConfigJobCategory> configJobCategoryList;

    public List<ConfigJobCategory> getConfigJobCategoryList() {
        return configJobCategoryList;
    }

    public void setConfigJobCategoryList(List<ConfigJobCategory> configJobCategoryList) {
        this.configJobCategoryList = configJobCategoryList;
    }
}
