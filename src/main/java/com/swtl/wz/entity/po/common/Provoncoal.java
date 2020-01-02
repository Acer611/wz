package com.swtl.wz.entity.po.common;

import com.swtl.wz.entity.po.common.City;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Provoncoal  implements Serializable{

    private static final long serialVersionUID =1L;
    @ApiModelProperty(value = "省的ID")
    private Long pid;
    @ApiModelProperty(value = "省名称")
    private String provincial;

    @ApiModelProperty(value = "城市列表信息")
    private List<City> cityList;


    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getProvincial() {
        return provincial;
    }

    public void setProvincial(String provincial) {
        this.provincial = provincial;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
