package com.habuma.spitter.persistence.jpa;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.persistence.SpitterDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SpitterDaoJpaImpl extends AbstractDaoJpaImpl<Spitter> implements SpitterDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveOrUpdate(Spitter spitter) {
        em.merge(spitter);
    }

    @Override
    public void delete(Long id) {
        try {
            em.remove(get(id));
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Spitter spitter) {
        em.remove(spitter);
    }

    @Override
    public Spitter get(Long id) {
        return em.find(Spitter.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Spitter> getAll() {
        return em.createQuery("SELECT s FROM Spitter s").getResultList();
    }

    public void addSpitter(Spitter spitter) {
        em.persist(spitter);
    }

    public Spitter getSpitterByUsername(String username) {
        String query = "SELECT s FROM Spitter s WHERE s.username = :username";
        return (Spitter) em.createQuery(query).
                setParameter("username", username).
                getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        String query = "SELECT s FROM Spittle s WHERE s.spitter.username = :username";
        return (List<Spittle>) em.createQuery(query).
                setParameter("username", spitter.getUsername()).
                getResultList();
    }


}