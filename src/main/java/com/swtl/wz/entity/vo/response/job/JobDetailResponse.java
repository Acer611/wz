package com.swtl.wz.entity.vo.response.job;

import com.swtl.wz.entity.po.job.PositionEntity;
import com.swtl.wz.entity.po.kf.KfDetail;
import com.swtl.wz.entity.vo.response.CommonResponse;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * 职位详情的返回信息
 */
public class JobDetailResponse extends CommonResponse {

    @ApiModelProperty(value = "职位详情")
    private PositionEntity positionEntity;

    @ApiModelProperty(value = "职位对应客服信息")
    private KfDetail kfDetail;


    public PositionEntity getPositionEntity() {
        return positionEntity;
    }


    public KfDetail getKfDetail() {
        return kfDetail;
    }

    public void setKfDetail(KfDetail kfDetail) {
        if(kfDetail.getId()==null){
            kfDetail.setId(0L);
        }
        if(kfDetail.getConfId()==null){
            kfDetail.setConfId(0L);
        }
        if(kfDetail.getName()==null){
            kfDetail.setName("");
        }
        if(kfDetail.getQq()==null){
            kfDetail.setQq("");
        }
        if(kfDetail.getAliPay()==null){
            kfDetail.setAliPay("");
        }
        if(kfDetail.getWechat()==null){
            kfDetail.setWechat("");
        }
        this.kfDetail = kfDetail;
    }

    public void setPositionEntity(PositionEntity positionEntity) {

        if(positionEntity.getTitle()==null){
            positionEntity.setTitle("");
        }

        if(positionEntity.getType()==null){
            positionEntity.setType("");
        }
        if(positionEntity.getCleanType()==null){
            positionEntity.setCleanType("");
        }
        if(positionEntity.getNeedPeople()==null){
            positionEntity.setNeedPeople(0);
        }
        if(positionEntity.getHasPeople()==null){
            positionEntity.setHasPeople(0);
        }
        if(positionEntity.getReportPeople()==null){
            positionEntity.setReportPeople(0);
        }
        if(positionEntity.getMoney()==null){
            positionEntity.setMoney("");
        }
        if(positionEntity.getJobRequired()==null){
            positionEntity.setJobRequired("");
        }
        if(positionEntity.getWorkflow()==null){
            positionEntity.setWorkflow("");
        }
        if(positionEntity.getJobDetail()==null){
            positionEntity.setJobDetail("");
        }
        if(positionEntity.getAddress()==null){
            positionEntity.setAddress("");
        }
        if(positionEntity.getLocationName()==null){
            positionEntity.setLocationName("");
        }
        if(positionEntity.getCompanyName()==null){
            positionEntity.setCompanyName("");
        }

        if(positionEntity.getAuthentication()==null){
            positionEntity.setAuthentication(0);
        }

        if(positionEntity.getApplyStatus()==null){
            positionEntity.setApplyStatus(0);
        }
        if(positionEntity.getLikeStatus()==null){
            positionEntity.setLikeStatus(0);
        }
        this.positionEntity = positionEntity;
    }
}
