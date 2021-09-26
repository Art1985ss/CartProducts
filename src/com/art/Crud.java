package com.art;

import java.util.NoSuchElementException;
import java.util.Set;

public interface Crud<T> {
    Set<T> getAll();

    boolean save(T t);

    boolean update(T t) throws NoSuchElementException;

    T getById(long id) throws NoSuchElementException;

    boolean remove(T t);
}
