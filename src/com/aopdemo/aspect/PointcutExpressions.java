package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by 8e3Yn4uK on 17.03.2019
 */

@Aspect
public class PointcutExpressions {

    @Pointcut("execution(* com.aopdemo.dao.*.*(..))")
    public void forDAOPackage() {}

    @Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDAOPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

}
