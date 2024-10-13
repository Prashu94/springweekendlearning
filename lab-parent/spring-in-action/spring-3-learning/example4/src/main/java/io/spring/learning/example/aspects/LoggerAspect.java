package io.spring.learning.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggerAspect {

    private Logger LOGGER = Logger.getLogger(LoggerAspect.class.getName());

    @Around("execution(* io.spring.learning.example.services.*.*(..))")
    public void log(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info(joinPoint.getSignature().getName() + " method execution started");
        Instant start = Instant.now();
        joinPoint.proceed();
        Instant end = Instant.now();
        long timeElapsed = Duration.between(start, end).toMillis();
        LOGGER.info(joinPoint.getSignature().getName() + " method execution completed in " + timeElapsed + " milliseconds");
        LOGGER.info(joinPoint.getSignature().getName() + " method execution ended");
    }

    @Around("@annotation(io.spring.learning.example.interfaces.LogAspect)")
    public void logWithAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info(joinPoint.getSignature().getName() + " method execution started");
        Instant start = Instant.now();
        joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        LOGGER.info("Time took to execute the method : "+timeElapsed);
        LOGGER.info(joinPoint.getSignature().getName() + " method execution ended");
    }

    @AfterThrowing(value = "execution(* io.spring.learning.services.*.*(..))",throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        LOGGER.log(Level.SEVERE,joinPoint.getSignature()+ " An exception thrown with the help of" +
                " @AfterThrowing which happened due to : "+ex.getMessage());
    }

    @AfterReturning(value = "execution(* io.spring.learning.services.*.*(..))",returning = "retVal")
    public void logStatus(JoinPoint joinPoint,Object retVal) {
        LOGGER.log(Level.INFO,joinPoint.getSignature()+ " Method successfully processed with the status " +
                retVal.toString());
    }
}
