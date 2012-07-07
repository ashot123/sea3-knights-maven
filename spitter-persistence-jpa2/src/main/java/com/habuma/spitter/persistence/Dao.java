package com.habuma.spitter.persistence;

import com.habuma.spitter.domain.Persistent;

import java.util.List;

public interface Dao<T extends Persistent> {
    void saveOrUpdate(T persistent);

    void delete(Long id);

    void delete(T persistent);

    T get(Long id);

    List<T> getAll();
}
