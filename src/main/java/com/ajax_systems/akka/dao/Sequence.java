package com.ajax_systems.akka.dao;

import java.util.concurrent.ConcurrentHashMap;


public class Sequence<T> extends ConcurrentHashMap<T, Long> {

    public Long getAmount(T o) {
        Long amount = super.get(o);
        amount = (amount!=null) ? amount + 1 : 1;
        super.put(o, amount);
        return amount;
    }
}
