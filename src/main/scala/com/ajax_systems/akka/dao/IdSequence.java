package com.ajax_systems.akka.dao;

import java.util.concurrent.ConcurrentHashMap;


public class IdSequence<T> {

    private ConcurrentHashMap<T, Integer> sequence = new ConcurrentHashMap<>();

    public Integer get(T o) {
        Integer id = sequence.get(o);
        if (id==null) id = sequence.size() + 1;
        sequence.put(o, id);
        return id;
    }
}
