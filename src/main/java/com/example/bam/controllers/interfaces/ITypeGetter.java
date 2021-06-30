package com.example.bam.controllers.interfaces;

import com.example.bam.types.Person;

import java.util.Set;
import java.util.Optional;

public interface ITypeGetter<T> {
    Set<T> getAll();
    T getById(String id);
}
