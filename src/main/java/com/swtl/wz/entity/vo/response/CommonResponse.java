package com.swtl.wz.entity.vo.response;

import com.swtl.wz.common.constant.ErrorConstant;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @program wz
 * @description:
 * @author: apple
 * @create: 2019/11/11 09:36
 */

public class CommonResponse implements Serializable {

    /**
     * 返回码，正常时返回为0
     */
    @ApiModelProperty(value="返回码，正常时返回为200")
    private Integer retCode = ErrorConstant.SUCCESS;
    /**
     * 返回消息信息
     */
    @ApiModelProperty(value="消息信息")
    private String retMsg = "success";

    /**
     * 返回信息主题
     */
    @ApiModelProperty(value="返回信息主题")
    private Object object;

    public CommonResponse() {
    }

    public CommonResponse(Integer retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public CommonResponse(Integer retCode, String retMsg, Object object) {
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.object = object;
    }

    public Integer getRetCode() {
        return retCode;
    }
    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }
    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }



}
