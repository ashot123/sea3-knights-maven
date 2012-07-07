package com.habuma.spitter.persistence;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;

import java.util.List;

/**
 * User: ashot
 * Date: 7/5/12
 * Time: 7:59 PM
 */
public interface SpittleDao extends Dao<Spittle> {
    Spitter getOwnerSpitter(Spittle spittle);

    Spittle getRecentSpittleForSpitter(Long spitterId);

    List<Spittle> getSpittlesForSpitter(Spitter spitter);
}
