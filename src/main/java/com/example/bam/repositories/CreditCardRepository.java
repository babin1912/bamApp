package com.example.bam.repositories;


import com.example.bam.types.Entities.CreditCardEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

@Repository
@Transactional
public interface CreditCardRepository extends CrudRepository<CreditCardEntity, String> {

    @Query(value = "call get_card_by_id(:id);", nativeQuery = true) // procedure using query
    Optional<CreditCardEntity> getCardById(@Param("id") String  id);

    @Query(value = "call find_all_cards();", nativeQuery = true) // procedure using query
    Set<CreditCardEntity> getAll();

    @Query(value = "call get_card_by_user_id(:personId);", nativeQuery = true) // procedure using query
    Set<CreditCardEntity> getAllByUserId(@Param("personId") String personId);

    @Procedure(name = "Card.cardById")// multiple procedure output
    Map<String, Object> cardById(String id);




}
