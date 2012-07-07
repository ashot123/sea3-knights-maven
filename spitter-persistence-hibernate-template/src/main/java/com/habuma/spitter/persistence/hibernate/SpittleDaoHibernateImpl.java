package com.habuma.spitter.persistence.hibernate;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.persistence.SpittleDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Transactional(propagation = Propagation.REQUIRED)
public class SpittleDaoHibernateImpl extends AbstractDaoHibernateImpl<Spittle> implements SpittleDao {

    public SpittleDaoHibernateImpl() {
    }


    @Override
    public void saveOrUpdate(Spittle spittle) {
        currentSession().saveOrUpdate(spittle);
    }

    @Override
    public void delete(Long id) {
        Query query = currentSession().createQuery("delete Spittle where :id = id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void delete(Spittle spittle) {
        currentSession().delete(spittle);
    }

    @Override
    public Spittle get(Long id) {
        return (Spittle) currentSession().get(Spittle.class, id);
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public List<Spittle> getAll() {
        return currentSession().createQuery("from Spittle").list();
    }

    // Extra methods
    @Override
    public Spitter getOwnerSpitter(Spittle spittle) {
        return spittle.getSpitter();
    }


    /*public void addSpitter(Spitter spitter) {
        currentSession().save(spitter);
    }*/


    /* public Spitter getSpitterById(long id) {
        return (Spitter) currentSession().get(Spitter.class, id);
    }*/


    /*  public void saveSpitter(Spitter spitter) {
            currentSession().update(spitter);
        }
    */


    /* public void saveSpittle(Spittle spittle) {
        currentSession().save(spittle);
    }*/


/*
public void deleteSpittle(long id) {
    currentSession().delete(getSpittleById(id));
}*/


    /*  public Spittle getSpittleById(long id) {
        return (Spittle) currentSession().get(Spittle.class, id);
    }*/


    /*public List<Spitter> findAllSpitters() {
        // TODO Auto-generated method stub
        return null;
    }*/
}
