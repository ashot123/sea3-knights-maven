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
        spitter.setFullName("Aram paronikyan");
        spitter.setUsername("Aramo");
        spitter.setPassword("armagedon");
        spitter.setEmail("aramo@gmail.com");
        spitter.setUpdateByEmail(true);

        dao.addSpitter(spitter);*/

      /*  Spitter spitterToUpdate = new Spitter();
        spitterToUpdate.setId(1L);
        spitterToUpdate.setFullName("Aram Paronikyan");
        spitterToUpdate.setUsername("Aram");
        spitterToUpdate.setPassword("armada");

        dao.saveSpitter(spitterToUpdate);*/


        Spitter retrievedSpitter = dao.getSpitterById(1L);
        System.out.print(retrievedSpitter);
    }
}
