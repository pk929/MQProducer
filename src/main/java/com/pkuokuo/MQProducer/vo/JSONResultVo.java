package com.pkuokuo.MQProducer.vo;



import com.pkuokuo.MQProducer.enums.LoginStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Slf4j
public class JSONResultVo implements Serializable {
    private Object code;
    private Object message;
    private Object data;
    private Object success;

    public static JSONResultVo result(LoginStatus status, boolean isSuccess, Object obj){
        JSONResultVo jsonResultVo = new JSONResultVo(status.getCode(),status.getMessage(),obj,isSuccess);
        log.warn("jsonResultVo1 ---------- > " + jsonResultVo.toString());
        return jsonResultVo;
    }

}
