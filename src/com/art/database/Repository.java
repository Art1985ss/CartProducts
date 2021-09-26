package com.art.database;

import com.art.Crud;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Repository<T> implements Crud<T> {
    protected final Set<T> set = new HashSet<>();
    protected AtomicInteger count = new AtomicInteger(0);

    @Override
    public Set<T> getAll() {
        return set;
    }

    @Override
    public boolean remove(T t) {
        return set.remove(t);
    }

    public boolean addList(List<T> listIn) {
        return set.addAll(listIn);
    }
}
