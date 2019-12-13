package com.kakaopay.shortening.common.exceptions;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * 커스텀 런타임
 * Created by MHLab on 2019-06-18..
 */

@Getter
public class CustomRuntimeException extends RuntimeException {

    @Getter(AccessLevel.NONE)
    private static final long serialVersionUID = -8924819962579683013L;

    private Object targetObj;

    public CustomRuntimeException(String message, Object targetObj) {
        super(message);
        this.targetObj = targetObj;
    }
}
