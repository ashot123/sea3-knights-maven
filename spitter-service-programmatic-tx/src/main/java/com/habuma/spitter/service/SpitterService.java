package com.habuma.spitter.service;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;

import java.util.List;

public interface SpitterService {
    List<Spittle> getRecentSpittles(int count);

    void saveSpittle(Spittle spittle);

    void saveSpitter(Spitter spitter);

    Spitter getSpitter(long id);

    void startFollowing(Spitter follower, Spitter followee);

    List<Spittle> getSpittlesForSpitter(Spitter spitter);

    List<Spittle> getSpittlesForSpitter(String username);

    Spitter getSpitter(String username);

    Spittle getSpittleById(long id);

    void deleteSpittle(long id);

    List<Spitter> getAllSpitters();
}
