package com.pkuokuo.MQProducer.enums;

import lombok.Getter;

@Getter
public enum LoginStatus {
    SUCCESS(200, "成功"),
    FAILURE(500, "失败"),
    UNKNOWN_EXCEPTION(501,"未知错误"),
    USER_NO_ACCESS(502, "用户无权访问"),
    PARAMETER_ERROR(503,"参数错误"),
    NO_COMPANY_FOUND(504,"未查询到该公司"),



    ;
    private Integer code;
    private String message;

    LoginStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
