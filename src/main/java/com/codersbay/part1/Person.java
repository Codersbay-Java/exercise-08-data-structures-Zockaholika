package com.codersbay.part1;

public class Person {
    String firstName;
    String sureName;
    int telephoneNumber;

    public Person(String firstName, String sureName, int telephoneNumber) {
        this.firstName = firstName;
        this.sureName = sureName;
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Firstname='" + firstName + '\'' +
                ", Surname='" + sureName + '\'' +
                ", Telephone number=" + telephoneNumber +
                '}';
    }
}
