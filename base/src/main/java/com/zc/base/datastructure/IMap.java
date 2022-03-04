package com.zc.base.datastructure;

public interface IMap<K,V> {

    void put(K key, V value);

    void delete(K key);

    V get(K key);

}
