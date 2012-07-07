package com.habuma.spitter;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.persistence.SpitterDao;
import com.habuma.spitter.persistence.SpittleDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("persistence-context.xml");
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
        SpittleDao spittleDao = (SpittleDao)context.getBean("spittleDaoHibernateImpl", SpittleDao.class);
        SpitterDao spitterDao = (SpitterDao)context.getBean("spitterDaoHibernateImpl", SpitterDao.class);

        Spitter retrievedSpitter = spitterDao.get(3L);
        System.out.print(retrievedSpitter);

        //Spittle spitter = spitterDao.getRecentSpittle();

        //Spitter spitter = spitterDao.getSpitterByUsername("artnames");
        //System.out.print(spitter);

        /*Spitter spitter = new Spitter();
        spitter.setFullName("Ashot Karakhanyan4");
        spitter.setUsername("ashotk");
        spitter.setPassword("anacond");
        spitter.setEmail("ashot@pisem.net");
        spitter.setUpdateByEmail(true);

        spitterDao.addSpitter(spitter);*/

        //spitterDao.delete(1L);



    }
}
