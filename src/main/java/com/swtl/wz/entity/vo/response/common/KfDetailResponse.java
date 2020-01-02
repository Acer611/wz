package com.swtl.wz.entity.vo.response.common;

import com.swtl.wz.entity.po.kf.KfDetail;
import com.swtl.wz.entity.vo.response.CommonResponse;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class KfDetailResponse extends CommonResponse {


   @ApiModelProperty(value = "客服信息列表")
   private  List<KfDetail> kfDetailList ;

    public List<KfDetail> getKfDetailList() {
        return kfDetailList;
    }

    public void setKfDetailList(List<KfDetail> kfDetailList) {
        this.kfDetailList = kfDetailList;
    }
}
