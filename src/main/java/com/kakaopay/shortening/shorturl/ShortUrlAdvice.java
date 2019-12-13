package com.kakaopay.shortening.shorturl;

import com.kakaopay.shortening.shorturl.exceptions.ShortKeyNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.view.RedirectView;

/**
 * ShortUrl Controller에서 발생하는 Custom 예외를 처리하는 메서드
 * Created by MHLab on 2019/12/12..
 */


@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ShortUrlAdvice {

    /**
     * ShortUrl key를 찾지 못하였을 때 발생하는 예외에 대한 처리
     * @param exception
     * @return
     */
    @ExceptionHandler(ShortKeyNotFoundException.class)
    public RedirectView ShortUrlKeyNotFound(ShortKeyNotFoundException exception) {
        return new RedirectView("?error=nf");
    }

}
