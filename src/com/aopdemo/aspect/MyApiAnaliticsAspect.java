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
@Order(2)
public class MyApiAnaliticsAspect {

    @Before("com.aopdemo.aspect.PointcutExpressions.forDaoPackageNoGetterSetter()")
    public void performApiAnalitics(){

        System.out.println("\n Performing API Analitics");
    }
}
