package com.kakaopay.shortening.common.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 퍼포먼스를 체크하기 위한 어노테이션
 *
 * Created by MHLab on 2019/12/12..
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PerformanceLog {

}