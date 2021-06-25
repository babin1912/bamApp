package com.example.bam;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Entitka {
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
