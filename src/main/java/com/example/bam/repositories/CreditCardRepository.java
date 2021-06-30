package com.example.bam.repositories;


import com.example.bam.types.Entities.CreditCardEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.*;

/**
 * Repository for credit cards
 */
@Repository
@Transactional
public interface CreditCardRepository extends CrudRepository<CreditCardEntity, String> {

    /**
     * Finds card with given id
     * @param id
     * @return optional credit card entity
     */
    @Query(value = "call get_card_by_id(:id);", nativeQuery = true)
    Optional<CreditCardEntity> getCardById(@Param("id") String  id);

    /**
     * Finds all credit cards in database
     * @return set of CreditCardEntity type
     */
    @Query(value = "call find_all_cards();", nativeQuery = true)
    Set<CreditCardEntity> getAll();

    /**
     * Finds all credit cards assigned to user
     * @param personId
     * @return set of Credit card entities
     */
    @Query(value = "call get_card_by_user_id(:personId);", nativeQuery = true)
    Set<CreditCardEntity> getAllByUserId(@Param("personId") String personId);

    /**
     * Finding card by id but using procedure with out param
     * @param id
     * @return map of credit card attributes
     */
    @Procedure(name = "Card.cardById")// multiple procedure output
    Map<String, Object> cardById(String id);




}
