package com.example.bam.controllers.interfaces;

import com.example.bam.types.Person;

/**
 * La generics ;)
 *
 * Interface for set services
 *
 * @param <T> given type
 */
public interface ITypeSetter<T> {

    T saveNew(T unit) throws Exception;
}
