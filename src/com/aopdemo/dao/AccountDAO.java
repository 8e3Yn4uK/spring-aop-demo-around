package com.aopdemo.dao;

import com.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 8e3Yn4uK on 13.03.2019
 */

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;


    public List<Account> findAccounts(boolean tripWire){

        if (tripWire){
            throw new RuntimeException("No soup for you)");
        }

        List<Account> myAccounts = new ArrayList<>();
        myAccounts.add(new Account("John", "user"));
        myAccounts.add(new Account("Sara", "admin"));
        myAccounts.add(new Account("Vova", "user"));
        return myAccounts;
    }

    public void addAccount(Account theAccount, boolean vipFlag){
        System.out.println("\n" + getClass() + " : Doing my DB work - adding account");
    }

    public boolean doWork(){
        System.out.println("\n" + getClass() + " : doWork() ");
        return false;
    }
}
