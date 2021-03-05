package com.shaunwassell;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    static class Person {
        public final Integer id;
        public final String name;
        public final Boolean likesPizza;

        public Person(Integer id, String name, Boolean likesPizza) {
            this.id = id;
            this.name = name;
            this.likesPizza = likesPizza;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", likesPizza=" + likesPizza +
                    '}';
        }
    }

    static class PersonUtils {
        public static String getFirstName(Person person) {
            return person.name.split(" ")[0];
        }
    }

    static void dataFormattingExample() {
        // Univariate arrays
        Integer[] ids = { 123, 234, 345, 456 };
        String[] names = { "John Doe", "Jane Jones", "Bill Smith", "Betsy Garcia" };
        Boolean[] likesPizza = { false, true, true, false };

        // Multivariate Arrays
        Integer[] person1 = { 123, 0, 1990, 3, 4 };
        Integer[] person2 = { 234, 1, 1979, 10, 5 };
        // ...

        Integer[][] peopleData = {
                { 123, 0, 1990, 3, 4 },
                { 234, 1, 1979, 10, 5 }
                // ...
        };

        // Data Objects
        List<Person> peopleList = new ArrayList<>();
        peopleList.add(new Person(123, "John Doe", false));
        peopleList.add(new Person(234, "Jane Jones", true));
        // ...
    }

    public static void main(String[] args) {
        List<String> adultLines = TextLoader.getLines("adult-sample.data");
        List<PersonRecord> people = adultLines.stream()
                .map(line -> PersonRecordUtil.parsePerson(line))
                .collect(Collectors.toList());

        people.stream().forEach(person -> System.out.println(person));
    }
}
