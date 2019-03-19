package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by 8e3Yn4uK on 13.03.2019
 */

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Around("execution(* com.aopdemo.service.TrafficFortuneService.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

        myLogger.info("\nExecuting @Around on method: " + theProceedingJoinPoint.getSignature().toShortString());
        long begin = System.currentTimeMillis();
        Object result = theProceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        myLogger.info("\nDuration " + duration / 1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint){

        myLogger.info("\nExecuting @AfterFinally on method: " + theJoinPoint.getSignature().toShortString());
    }

    @AfterThrowing(
            pointcut = "execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception")
    public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable exception){

        myLogger.info("\nExecuting @AfterThrowing on method: " + theJoinPoint.getSignature().toShortString());
        myLogger.info("\nThe exception is: " + exception);
    }


    @AfterReturning(
            pointcut = "execution(* com.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

        myLogger.info("\nExecuting @AfterReturning on method: " + theJoinPoint.getSignature().toShortString());
        myLogger.info("\n" + result);

        convertAccountNamesToUpperCase(result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        for (Account temp : result){
            String theUpperName = temp.getName().toUpperCase();
            temp.setName(theUpperName);
        }
    }


    @Before("com.aopdemo.aspect.PointcutExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

        myLogger.info("\n Executing @Before advice");


        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        myLogger.info("\n Method: " + methodSignature);

        // display method arguments
        Object[] args = theJoinPoint.getArgs();
        for (Object temp : args) {
            myLogger.info(temp.toString());
        }

    }
}
