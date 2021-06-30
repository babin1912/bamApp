package com.example.bam.types;

import java.util.HashSet;
import java.util.Set;

public class Person {

    private String id;

    private String firstName;

    private String lastName;

    private char gender;

    private int accountBalance;

    private Set<CreditCard> creditCards = new HashSet<>();

    public Person() {
    }

    public Person(String id, String firstName, String lastName, char gender, int accountBalance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.accountBalance = accountBalance;
    }

    public static Person getTestPerson(String id) {
        return new Person(id, "peter", "frantisek", 'M', 0);
    }

    /* generated */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Set<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(Set<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", accountBalance=" + accountBalance +
                ", creditCards=" + creditCards +
                '}';
    }
}
