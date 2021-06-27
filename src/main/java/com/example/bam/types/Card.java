package com.example.bam.types;


import com.example.bam.types.Entities.PersonEntity;

public class Card {

    private String id;

    private PersonEntity owner;

    public Card(String id, PersonEntity owner) {
        this.id = id;
        this.owner = owner;
    }

    /* generated code */
    public PersonEntity getOwner() {
        return owner;
    }

    public void setOwner(PersonEntity owner) {
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Card{" +
                "owner=" + owner +
                '}';
    }
}
