package com.habuma.spitter.persistence;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;

/**
 * User: ashot
 * Date: 7/5/12
 * Time: 7:59 PM
 */
public interface SpittleDao extends Dao<Spittle> {
    Spitter getOwnerSpitter(Spittle spittle);

}
