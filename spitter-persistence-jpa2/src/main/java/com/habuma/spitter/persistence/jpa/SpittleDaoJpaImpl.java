package com.habuma.spitter.persistence.jpa;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import com.habuma.spitter.persistence.SpittleDao;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class SpittleDaoJpaImpl extends AbstractDaoJpaImpl<Spittle> implements SpittleDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveOrUpdate(Spittle spittle) {
        em.persist(spittle);
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
    public void delete(Spittle spittle) {
        em.remove(spittle);
    }

    @Override
    public Spittle get(Long id) {
        return em.find(Spittle.class, id);
    }

    @Override
    public List<Spittle> getAll() {
        return em.createQuery("SELECT s FROM Spittle s", Spittle.class).getResultList();
    }


    public Spitter getOwnerSpitter(Spittle spittle) {
        String query = "SELECT s FROM Spitter s WHERE s.id = :spittleId";
        return em.createQuery(query, Spitter.class)
                .setParameter("spittleId", spittle.getId())
                .getSingleResult();
    }


    public Spittle getRecentSpittleForSpitter(Long spitterId) {
        String query = "SELECT s FROM Spittle s " +
                "WHERE s.id = (select max(s.id) from s WHERE spitter.id = :spitterId)";
        return em.createQuery(query, Spittle.class)
                .setParameter("spitterId", spitterId)
                .getSingleResult();

    }

    public List<Spittle> getSpittlesForSpitter(Spitter spitter) {
        String query = "SELECT s FROM Spittle s WHERE s.spitter.username = :username";
        return em.createQuery(query, Spittle.class).
                setParameter("username", spitter.getUsername()).
                getResultList();
    }

}