package com.habuma.spitter;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.persistence.SpitterDao;
import com.habuma.spitter.persistence.SpittleDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainJpa {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("persistence-context-jpa.xml");
        SpitterDao spitterDao = context.getBean("spitterDaoJpaImpl", SpitterDao.class);
        SpittleDao spittleDao = (SpittleDao)context.getBean("spittleDaoJpaImpl", SpittleDao.class);

        /*Spitter retrievedSpitter = spitterDao.get(3L);
        System.out.print(retrievedSpitter);*/

        /*Spittle spittle = spittleDao.getRecentSpittleForSpitter(3L);
        System.out.println("---Result spittle---");
        System.out.println(spittle);
*/
        //System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        /*SpittleDao spittleDao = (SpittleDao)context.getBean("spittleDaoHibernateImpl", SpittleDao.class);
        SpitterDao spitterDao = (SpitterDao)context.getBean("spitterDaoHibernateImpl", SpitterDao.class);

        Spitter retrievedSpitter = spitterDao.get(3L);
        System.out.print(retrievedSpitter);*/

        //Spittle spitter = spitterDao.getRecentSpittleForSpitter();

        //Spitter spitter = spitterDao.getSpitterByUsername("artnames");
        //System.out.print(spitter);

       /* Spitter spitter = new Spitter();
        spitter.setFullName("Hovik Petrosyan");
        spitter.setUsername("hovik1");
        spitter.setPassword("hovik1");
        spitter.setEmail("hovik@pisem.net");
        spitter.setUpdateByEmail(true);

        spitterDao.addSpitter(spitter);
        */

        Spitter spitter = spitterDao.get(3L);
        //spitterDao.delete(8L);
        System.out.print(spitter);



    }
}
