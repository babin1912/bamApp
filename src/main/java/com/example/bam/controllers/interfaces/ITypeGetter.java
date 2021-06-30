package com.example.bam.controllers.interfaces;

import com.example.bam.types.Person;

import java.util.Set;
import java.util.Optional;

/**
 * La generics ;)
 *
 * Interface for get services
 *
 * @param <T> given type
 */
public interface ITypeGetter<T> {

    /**
     * Giving all items of stored items
     * @return set of found items
     */
    Set<T> getAll();

    /**
     * Giving item with id
     * @param id
     * @return item of given type
     */
    T getById(String id);
}
