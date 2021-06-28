package com.example.bam.types.Entities;

import javax.persistence.*;

@Entity
@NamedStoredProcedureQuery(name = "Card.cardById",
        procedureName = "card_by_id", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "id", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "cardNumber", type = String.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "personId", type = Long.class)
})
@Table(name = "cards")
public class CreditCardEntity {


    @Id
    @Column(name ="card_number")
    private String cardNumber;

    @Column(name = "person_id")
    private long owner;

    public CreditCardEntity() {
    }



    public void setCardNumber(String cardId) {
        this.cardNumber = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public CreditCardEntity(String cardNumber, long person) {
        this.cardNumber = cardNumber;
        this.owner = person;
    }

/*    @JoinColumn(name="person_id", referencedColumnName="person_id",foreignKey=@ForeignKey(name = "fk_person_id"),
            nullable = false)
    private PersonEntity owner;
   @ManyToOne(fetch = FetchType.EAGER)
    public CreditCardEntity(String cardNumber, PersonEntity person) {
        this.cardNumber = cardNumber;
        this.owner = person;
    }
    public PersonEntity getOwner() {
        return owner;
    }

    public void setOwner(PersonEntity person) {
        this.owner = person;
    }
    */

    public long getOwner() {
        return owner;
    }

    public void setOwner(long owner) {
        this.owner = owner;
    }
}
