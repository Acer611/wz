package com.swtl.wz.entity.vo.response.job;

import com.swtl.wz.entity.po.job.CompanyEntity;
import com.swtl.wz.entity.vo.response.CommonResponse;
import io.swagger.annotations.ApiModelProperty;

/**
 * 公司的信息返回对象
 */
public class CompanyResponse extends CommonResponse {
    @ApiModelProperty(value = "职位详情")
    private CompanyEntity companyEntity;


    public CompanyEntity getCompanyEntity() {
        return companyEntity;
    }

    public void setCompanyEntity(CompanyEntity companyEntity) {
        if(companyEntity.getAddress()==null){
            companyEntity.setAddress("");
        }
        if(companyEntity.getAuthentication()==null){
            companyEntity.setAuthentication(0);
        }
        if(companyEntity.getCompany()==null){
            companyEntity.setCompany("");
        }
        if(companyEntity.getDescription()==null){
            companyEntity.setDescription("");
        }
        if(companyEntity.getDomain()==null){
            companyEntity.setDomain(0);
        }
        if (companyEntity.getType()==null){
            companyEntity.setType("");
        }
        if(companyEntity.getStatus()==null){
            companyEntity.setStatus("");
        }
        if(companyEntity.getRegisteredCapital()==null){
            companyEntity.setRegisteredCapital("");
        }
        if(companyEntity.getRegistrationAuthority()==null){
            companyEntity.setRegistrationAuthority("");
        }
        if(companyEntity.getCreditCode()==null){
            companyEntity.setCreditCode("");
        }
        if(companyEntity.getGroupCode()==null){
            companyEntity.setGroupCode("");
        }
        if(companyEntity.getBusinessScop()==null){
            companyEntity.setBusinessScop("");
        }

        this.companyEntity = companyEntity;
    }
}
