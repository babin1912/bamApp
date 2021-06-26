package com.example.bam.Entities;

import javax.persistence.*;

@Entity
@Table(name = "cards")
public class CreditCard {


    @Id
    @Column(name ="card_number")
    private String cardNumber;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="person_id", referencedColumnName="person_id",foreignKey=@ForeignKey(name = "fk_person_id"),
            nullable = false)
    private Person person;

    public CreditCard() {
    }

    public CreditCard(String cardNumber, Person person) {
        this.cardNumber = cardNumber;
        this.person = person;
    }

    public void setCardNumber(String cardId) {
        this.cardNumber = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
