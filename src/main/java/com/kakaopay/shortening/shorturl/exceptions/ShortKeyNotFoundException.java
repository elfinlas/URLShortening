package com.kakaopay.shortening.shorturl.exceptions;

import com.kakaopay.shortening.common.exceptions.CustomRuntimeException;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * Short Key를 찾지 못하였을 때 발생하는 커스텀 예외
 * Created by MHLab on 2019/12/13..
 */

@Getter
public class ShortKeyNotFoundException extends CustomRuntimeException {

    @Getter(AccessLevel.NONE)
    private static final long serialVersionUID = -2502086546905021480L;

    public ShortKeyNotFoundException(String message, Object targetObj) {
        super(message, targetObj);
    }
}
