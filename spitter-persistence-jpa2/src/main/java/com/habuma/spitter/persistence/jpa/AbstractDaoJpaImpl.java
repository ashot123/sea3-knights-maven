package com.habuma.spitter.persistence.jpa;

import com.habuma.spitter.domain.Persistent;
import com.habuma.spitter.persistence.Dao;

/**
 * User: ashot
 * Date: 7/5/12
 * Time: 6:19 PM
 */

public abstract class AbstractDaoJpaImpl<T extends Persistent> implements Dao<T> {
    protected AbstractDaoJpaImpl() {
    }
/*

    @Autowired
    protected SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

   */
/* public AbstractHibernateDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
*//*



    protected Session currentSession() {
        return sessionFactory.openSession();
    }
*/


}
