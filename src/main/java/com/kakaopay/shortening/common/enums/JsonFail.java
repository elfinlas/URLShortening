package com.kakaopay.shortening.common.enums;

/**
 * Json 응답 실패 데이터 코드를 담는 열거형
 *
 * Created by mhlab(dex) on 2019-03-08.
 */

public enum JsonFail {

    //
    CONVERT_URL("CF-URL-0001", "Change fail."),

    //ETC
    EXCEPTION_ETC("CF-EXCEPTION-9999", "Server error. (Java exception.)"),
    ETC("CF-ETC-9999", "Etc");


    private String code;
    private String msg;
    JsonFail(String code, String msg) { this.code = code; this.msg = msg; }
    public String code() {return this.code;}
    public String msg() {return this.msg;}
}
