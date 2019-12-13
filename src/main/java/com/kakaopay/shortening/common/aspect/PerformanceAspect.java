package com.kakaopay.shortening.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by MHLab on 2019/12/12..
 */

@Aspect
@Component
@Slf4j
public class PerformanceAspect {

    /**
     * 퍼포먼스 체크를 위한 AOP 적용
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("@annotation(com.kakaopay.shortening.common.annotations.PerformanceLog)")
    public Object performanceCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("["+joinPoint.getSignature().getName()+"]");

        Object proceed = joinPoint.proceed();

        stopWatch.stop();
        log.info(stopWatch.prettyPrint());
        return proceed;
    }
}
