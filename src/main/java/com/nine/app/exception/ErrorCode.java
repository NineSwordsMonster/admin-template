package com.nine.app.exception;

/**
 * Create by 王佳
 *
 * @author 王佳
 * @date 2019/9/20 14:03
 */
public enum ErrorCode {
    // InvalidRequestException 400
    ParamError(100, "ParamError", " 参数错误"),
    PasswordError(10401, "PasswordError", " 密码错误"),
    InvalidAccount(11401, "InvalidAccount", " 账号已停用"),
    ;

    private int status;
    private String code;
    private String reason;

    ErrorCode(int status, String code, String reason) {
        this.status = status;
        this.code = code;
        this.reason = reason;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
