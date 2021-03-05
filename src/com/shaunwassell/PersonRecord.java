package com.shaunwassell;

public class PersonRecord {
    public final Integer age;
    public final String employmentStatus;
    public final Boolean makesMoreThan50k;

    public PersonRecord(Integer age, String employmentStatus, Boolean makesMoreThan50k) {
        this.age = age;
        this.employmentStatus = employmentStatus;
        this.makesMoreThan50k = makesMoreThan50k;
    }

    @Override
    public String toString() {
        return "PersonRecord{" +
                "age=" + age +
                ", employmentStatus='" + employmentStatus + '\'' +
                ", makesMoreThan50k=" + makesMoreThan50k +
                '}';
    }
}
