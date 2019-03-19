package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by 8e3Yn4uK on 17.03.2019
 */

@Aspect
@Component
@Order(1)
public class MyLoggingToCloudAspect {

    @Before("com.aopdemo.aspect.PointcutExpressions.forDaoPackageNoGetterSetter()")
    public void logginToCloud(){

        System.out.println("\n Logging to cloud");
    }
}
