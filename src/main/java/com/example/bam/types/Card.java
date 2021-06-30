package com.example.bam.types;


/**
 * Class presenting Card ;)
 */
public class Card {

    private String id;

    private String owner;

    public Card() {
    }

    public Card(String id, String owner) {
        this.id = id;
        this.owner = owner;
    }

    /* generated code */
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
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
