package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppContext {


    private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

    private AppContext(){}

    public static ApplicationContext getInstance(){
        return applicationContext;
    }

}