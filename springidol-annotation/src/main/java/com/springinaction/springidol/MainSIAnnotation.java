package com.springinaction.springidol;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: ashot
 * Date: 10.06.12
 * Time: 1:22
 */
public class MainSIAnnotation {
    public static void main(String[] args) throws PerformanceException {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("springidol-annotation.xml");
        //com.springinaction.springidol.Performer performer = (com.springinaction.springidol.Performer) ctx.getBean("poeticDuke");
        //performer.perform();

        //com.springinaction.springidol.Auditorium theStage = (com.springinaction.springidol.Auditorium) ctx.getBean("auditorium");


        Performer performer = (Performer) ctx.getBean("eddie");
        performer.perform();

    }
}
