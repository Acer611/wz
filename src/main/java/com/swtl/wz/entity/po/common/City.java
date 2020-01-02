package com.swtl.wz.entity.po.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class City implements Serializable {

    private static final long serialVersionUID =1L;
    @ApiModelProperty(value = "城市ID")
    private Long id;
    @ApiModelProperty(value = "阿里code")
    private String alipayCode;

    @ApiModelProperty(value = "阿里名称")
    private String alipayName;
    @ApiModelProperty(value = "code")
    private String code;
    @ApiModelProperty(value = "getuiNum")
    private String getuiNum;
    @ApiModelProperty(value = "城市名称")
    private String name;

    @ApiModelProperty(value = "拼音")
    private String spellCode;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlipayCode() {
        return alipayCode;
    }

    public void setAlipayCode(String alipayCode) {
        this.alipayCode = alipayCode;
    }

    public String getAlipayName() {
        return alipayName;
    }

    public void setAlipayName(String alipayName) {
        this.alipayName = alipayName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGetuiNum() {
        return getuiNum;
    }

    public void setGetuiNum(String getuiNum) {
        this.getuiNum = getuiNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpellCode() {
        return spellCode;
    }

    public void setSpellCode(String spellCode) {
        this.spellCode = spellCode;
    }
}
