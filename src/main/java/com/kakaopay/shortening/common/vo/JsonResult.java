package com.kakaopay.shortening.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * Json 응답 객체
 * Created by MHLab on 2019/12/12..
 */


@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@JsonInclude(JsonInclude.Include.NON_NULL) //Null 인 것은 Json으로 표현한다.
public class JsonResult<T> {
    private boolean isSuccess;
    @NotNull private String code;
    private String msg;
    private T data;


    @Builder
    public JsonResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.isSuccess = isSuccess();
    }

    /**
     * 현재 코드가 성공인지 실패인지 체크하는 메서드
     * @return
     */
    public boolean isSuccess() {
        if (this.code != null && this.code.split("-")[0].toUpperCase().equals("CS")) {
            this.isSuccess = true;
            return true;
        }
        this.isSuccess = false;
        return false;
    }
}
