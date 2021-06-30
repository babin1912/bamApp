package com.example.bam.controllers.interfaces;

import com.example.bam.types.Person;

public interface ITypeSetter<T> {

    T saveNewPerson(T unit) throws Exception;
}
