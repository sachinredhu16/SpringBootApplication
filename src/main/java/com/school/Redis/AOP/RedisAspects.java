package com.school.Redis.AOP;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Aspect
@Component
public class RedisAspects {

    @Pointcut("execution (* com.school.Redis.Controller.RedisStudentController.addStudent(..))")
    public void pointCutExpressionForMethod(){}

    @Pointcut("execution (* com.school.Redis.Controller.RedisStudentController.*(..))")
    public void pointCutExpressionForClass(){}

    @Before("pointCutExpressionForMethod()")
    public void beforeMethod(){
        System.out.println("Before Execution start at : "+ LocalTime.now());
    }
    @After("pointCutExpressionForMethod()")
    public void afterMethod(JoinPoint joinPoint){
        System.out.println("After Execution ends at : "+ LocalTime.now());
    }
    @AfterReturning("pointCutExpressionForMethod()")
    public void afterReturningMethod(JoinPoint joinPoint){
        System.out.println("AfterReturning Execution ends at : "+ LocalTime.now());
    }
    @AfterThrowing("pointCutExpressionForMethod()")
    public void afterThrowingMethod(JoinPoint joinPoint){
        System.out.println("AfterThrowing Execution ends at : "+ LocalTime.now());
    }

    @Around("pointCutExpressionForMethod()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Execution start at : "+ LocalTime.now());

        System.out.println("Around Execution ends at : "+ LocalTime.now());
    }

}
