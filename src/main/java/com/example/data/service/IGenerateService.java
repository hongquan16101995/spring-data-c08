package com.example.data.service;

public interface IGenerateService<E> {
    Iterable<E> findAll();

    void save(E e);

    E findOne(Long id);
}
