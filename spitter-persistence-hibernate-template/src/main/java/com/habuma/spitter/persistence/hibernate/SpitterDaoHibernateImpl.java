package com.habuma.spitter.persistence.hibernate;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.persistence.SpitterDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Transactional(propagation = Propagation.REQUIRED)
public class SpitterDaoHibernateImpl extends AbstractDaoHibernateImpl<Spitter> implements SpitterDao {

    public SpitterDaoHibernateImpl() {
    }

    @Override
    public void saveOrUpdate(Spitter spitter) {
        currentSession().saveOrUpdate(spitter);
    }

    @Override
    public void delete(Long id) {
        Query query = currentSession().createQuery("delete Spitter where :id = id");
        query.setParameter("id", id);
        query.executeUpdate();

    }

    @Override
    public void delete(Spitter spitter) {
        currentSession().delete(spitter);
        currentSession().flush();
    }

    @Override
    public Spitter get(Long id) {
        return (Spitter) currentSession().get(Spitter.class, id);
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public List<Spitter> getAll() {
        return currentSession().createQuery("from Spitter").list();
    }


    // Extra methods
    @Override
    public void addSpitter(Spitter spitter) {
        currentSession().save(spitter);
    }

    @Override
    public Spittle getRecentSpittle() {
        Long maxId = (Long) currentSession().createQuery("select max(id)from Spittle").uniqueResult();
        Query query = currentSession().createQuery("from Spittle s where s.id = :maxId");
        query.setParameter("maxId", maxId);
        return (Spittle) query.uniqueResult();
    }

    @Override
    public Spitter getSpitterByUsername(String userName) {
        Query query = currentSession().createQuery("from Spitter s where s.username = :userName");
        query.setParameter("userName", userName);
        return (Spitter) query.uniqueResult();
    }

}
