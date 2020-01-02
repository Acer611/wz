package com.swtl.wz.entity.vo.response.common;

import com.swtl.wz.entity.po.common.City;
import com.swtl.wz.entity.vo.response.CommonResponse;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 城市返回对象
 */
public class CityResponse extends CommonResponse {

    @ApiModelProperty(value = "城市信息集合")
    private List<City> cityList ;
    @ApiModelProperty(value = "单个城市信息")
    private City city ;

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
