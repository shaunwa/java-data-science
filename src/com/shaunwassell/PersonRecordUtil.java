package com.shaunwassell;

public class PersonRecordUtil {
    public static PersonRecord parsePerson(String commaString) {
        String[] fields = commaString.split(",");
        try {
            Integer age = Integer.parseInt(fields[0].trim());
            String employmentStatus = fields[1].trim();
            Boolean makesMoreThan50k = fields[14].trim().equals(">50K");
            return new PersonRecord(age, employmentStatus, makesMoreThan50k);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
