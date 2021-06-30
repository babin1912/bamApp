package com.example.bam.repositories;

import com.example.bam.types.BankAccount;
import com.example.bam.types.Entities.BankAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for redis database with Bank accounts
 */
@Profile("production")
@Repository
public class BankAccountRepository {

    private HashOperations<String, Long, BankAccountEntity> hashOp;

    @Autowired
    @Qualifier("ridisik")
    public void setTemplate(RedisTemplate<String, BankAccount> template) {
        this.hashOp = template.opsForHash();
    }

    /**
     * Hash key used in database
     */
    public static final String HASH_KEY = "BankAccountEntity";

    public BankAccountEntity save(BankAccountEntity bankAccountEntity) {
        hashOp.put(HASH_KEY, bankAccountEntity.getId(), bankAccountEntity);
        return bankAccountEntity;
    }

    /**
     * Returns all Bank accounts
     * @return list of accounts
     */
    public List<BankAccountEntity> findAll() {
        return hashOp.values(HASH_KEY);
    }

    /**
     * Returns account with given id from database
     * @param id
     * @return bankAccountEntity
     */
    public BankAccountEntity findProductById(long id) {
        return hashOp.get(HASH_KEY, id);
    }

    /**
     * Removing account from database
     */
    public void deleteAccount(long id) {
        hashOp.delete(HASH_KEY, id);

    }
}
