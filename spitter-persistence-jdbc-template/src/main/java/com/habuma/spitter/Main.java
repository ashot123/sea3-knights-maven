package com.habuma.spitter;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.persistence.JdbcSpitterDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: ashot
 * Date: 6/24/12
 * Time: 9:18 PM
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        JdbcSpitterDao dao = ctx.getBean("jdbcSpitterDao", JdbcSpitterDao.class);

        /*Spitter spitter = new Spitter();
        spitter.setFullName("Alik Mheryan");
        spitter.setUsername("Alik");
        spitter.setPassword("tester");
        spitter.setEmail("alik@gmail.com");
        spitter.setUpdateByEmail(false);

        dao.addSpitter(spitter);*/

        /* Spitter spitterToUpdate = new Spitter();
        spitterToUpdate.setId(1L);
        spitterToUpdate.setFullName("Aram Paronikyan");
        spitterToUpdate.setUsername("Aramo");
        spitterToUpdate.setPassword("armada for aramo");

        dao.saveSpitter(spitterToUpdate);*/



        Spitter retrievedSpitter = dao.getSpitterById(3L);
        System.out.print(retrievedSpitter);
    }
}
