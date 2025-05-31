package com.shyamdemo.learning_springboot.datajpa;

import java.util.List;
import java.util.Optional;

public interface EntityService<T> {
    public List<T> fetchAll();

    public Optional<T> findById(Long id);

    public T create(T entity);

    public T update(Long id, T entity);

    public void delete(Long id);
}
