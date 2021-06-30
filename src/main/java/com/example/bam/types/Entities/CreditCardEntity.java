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
    private String owner;

    public CreditCardEntity() {
    }

    public void setCardNumber(String cardId) {
        this.cardNumber = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public CreditCardEntity(String cardNumber, String person) {
        this.cardNumber = cardNumber;
        this.owner = person;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
