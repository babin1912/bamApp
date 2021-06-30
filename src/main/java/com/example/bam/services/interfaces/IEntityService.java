package com.example.bam.services.interfaces;

import com.example.bam.types.CreditCard;
import com.example.bam.types.Entities.CreditCardEntity;
import com.example.bam.types.Entities.PersonEntity;
import com.example.bam.types.Person;

/**
 * Class for entity retyping
 */
public interface IEntityService {

    /**
     * Changing type from person to person entity
     * @param personEntity
     * @return person
     */
   static Person personFromEntity(PersonEntity personEntity) {
        return new Person(
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getLastName(),
                personEntity.getGender(),
                personEntity.getAccountBalance());
    }

    /**
     * Changing type from person entity to person
     * @param person
     * @return person entiry
     */
    static PersonEntity personToEntity(Person person) {
        return new PersonEntity(
                person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getGender(),
                person.getAccountBalance()
        );
    }

    /**
     * Changing type from credit card to it's entity
     * @param creditCardEntity
     * @return credit card
     */
    static CreditCard creditCardFromEntity(CreditCardEntity creditCardEntity) {
        return new CreditCard(creditCardEntity.getCardNumber(), creditCardEntity.getOwner());
    }

    /**
     * Changing type from credit card's entity to credit card
     * @param creditCard
     * @return credit card entity
     */
    static CreditCardEntity creditCardToEntity(CreditCard creditCard) {
        return new CreditCardEntity(
                creditCard.getId(),
                creditCard.getOwner()
        );
    }

}
