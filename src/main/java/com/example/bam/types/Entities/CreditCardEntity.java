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


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="person_id", referencedColumnName="person_id",foreignKey=@ForeignKey(name = "fk_person_id"),
            nullable = false)
    private PersonEntity owner;

    public CreditCardEntity() {
    }

    public CreditCardEntity(String cardNumber, PersonEntity person) {
        this.cardNumber = cardNumber;
        this.owner = person;
    }

    public void setCardNumber(String cardId) {
        this.cardNumber = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public PersonEntity getOwner() {
        return owner;
    }

    public void setOwner(PersonEntity person) {
        this.owner = person;
    }

}
