package com.springinaction.springidol;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: ashot
 * Date: 10.06.12
 * Time: 1:22
 */
public class MainSIAutowired {
    public static void main(String[] args) throws PerformanceException {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring-idol-autowired.xml");
        //Performer performer = (Performer) ctx.getBean("poeticDuke");
        //performer.perform();

        //Auditorium theStage = (Auditorium) ctx.getBean("auditorium");


        Performer performer = (Performer) ctx.getBean("kenny");
        performer.perform();
        ctx.close();
    }
}
