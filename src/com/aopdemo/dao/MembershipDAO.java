package com.aopdemo.dao;

import org.springframework.stereotype.Component;

/**
 * Created by 8e3Yn4uK on 15.03.2019
 */

@Component
public class MembershipDAO {

    public void addAccount(){

        System.out.println("\n" + getClass() + " Doing some stuff: adding a membership account!");
    }
}
