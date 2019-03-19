package com.aopdemo;

import com.aopdemo.dao.AccountDAO;
import com.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Created by 8e3Yn4uK on 13.03.2019
 */

public class AroundDemoApp {
    public static void main(String[] args) {

        // read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from the spring container
        TrafficFortuneService theTrafficFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);
        System.out.println("\nMain Program: AroundDemoApp");
        System.out.println("Calling getFortune");
        String data = theTrafficFortuneService.getFortune();
        System.out.println("\nMy Fortune is: " + data);
        System.out.println("Finished");

        // close the context
        context.close();
    }
}
