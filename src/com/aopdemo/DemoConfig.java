package com.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by 8e3Yn4uK on 13.03.2019
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.aopdemo")
public class DemoConfig {

}
