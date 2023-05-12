package org.etiya.core.services;

import java.util.List;

public interface GenericServices<T> {

    void add(T entity);

    void update(T entity);

    List<T> getAll();

    T getById(int id);

    T getByName(String name);
}
