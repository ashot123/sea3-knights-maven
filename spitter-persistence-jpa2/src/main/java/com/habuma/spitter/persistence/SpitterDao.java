package com.habuma.spitter.persistence;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;

import java.util.List;

/**
 * User: ashot
 * Date: 7/5/12
 * Time: 7:59 PM
 */
public interface SpitterDao extends Dao<Spitter> {

    void addSpitter(Spitter spitter);



    Spitter getSpitterByUsername(String username);

    public List<Spittle> getSpittlesForSpitter(Spitter spitter);

}
