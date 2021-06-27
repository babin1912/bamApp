package com.example.bam.repositories;

import com.example.bam.types.Entities.Person;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query(value = "call get_person_by_id(:id);", nativeQuery = true)
    Optional<Person> getPersonById(@Param("id") long id);

    @Query(value = "call find_all_people();", nativeQuery = true)
    Set<Person> getAll();
}
