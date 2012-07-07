package com.habuma.spitter.persistence.hibernate;

import com.habuma.spitter.domain.Persistent;
import com.habuma.spitter.persistence.Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: ashot
 * Date: 7/5/12
 * Time: 6:19 PM
 */

public abstract class AbstractDaoHibernateImpl<T extends Persistent> implements Dao<T> {
    protected AbstractDaoHibernateImpl() {
    }

    @Autowired
    protected SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

   /* public AbstractHibernateDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
*/


    protected Session currentSession() {
        return sessionFactory.openSession();
    }


}
