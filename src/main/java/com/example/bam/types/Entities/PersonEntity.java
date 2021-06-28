package com.example.bam.types.Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "people")
public class PersonEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="person_id")
    private Long id;


    @NotNull
    @Column(name ="firstname")
    private String firstName;


    @NotNull
    @Column(name ="lastname")
    private String lastName;

    @NotNull
    @Column(name ="gender")
    private char gender;



    @NotNull
    @Column(name ="account_ballance")
    private int accountBalance;

    public PersonEntity() {
    }

    public PersonEntity(long id,String firstName, String lastName, char gender, int accountBalance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.accountBalance = accountBalance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

}
