package com.aopdemo;

import com.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.logging.Logger;

/**
 * Created by 8e3Yn4uK on 13.03.2019
 */

public class AroundDemoApp {

    private static Logger myLogger = Logger.getLogger(AroundDemoApp.class.getName());

    public static void main(String[] args) {

        // read the spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from the spring container
        TrafficFortuneService theTrafficFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);
        myLogger.info("\nMain Program: AroundDemoApp");
        myLogger.info("Calling getFortune");
        String data = theTrafficFortuneService.getFortune();
        myLogger.info("\nMy Fortune is: " + data);
        myLogger.info("Finished");

        // close the context
        context.close();
    }
}
