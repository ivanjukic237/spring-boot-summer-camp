package com.ag04smarts.sha.models;

import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public class Person {

    private String firstName;
    private String lastName;
}
