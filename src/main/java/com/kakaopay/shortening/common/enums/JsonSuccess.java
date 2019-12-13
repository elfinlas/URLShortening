package com.kakaopay.shortening.common.enums;

/**
 * Json 응답 성공 데이터 코드를 담는 열거형
 *
 * Created by mhlab(dex) on 2019-03-08.
 */

public enum JsonSuccess {

    //Url 변환에 성공한 경우
    CONVERT_URL("CS-URL-0001","Change origin url 2 short url."),

    ETC("CS-ETC-9999", "Etc");


    private String code;
    private String msg;
    JsonSuccess(String code, String msg) { this.code = code; this.msg = msg; }
    public String code() {return this.code;}
    public String msg() {return this.msg;}
}
