package com.ajax_systems.akka.dao;

import java.util.concurrent.ConcurrentHashMap;


public class AmountSequence<T> {

    private ConcurrentHashMap<T, Long> sequence = new ConcurrentHashMap<>();

    public Long get(T o) {
        Long amount = sequence.get(o);
        amount = (amount!=null) ? amount + 1 : 1;
        sequence.put(o, amount);
        return amount;
    }
}