package com.shaunwassell;

public class FlowerRecordUtil {
    public static FlowerRecord parseFlower(String commaString) {
        String[] fields = commaString.split(",");
        try {
            Double sepalLength = Double.parseDouble(fields[0].trim());
            Double sepalWidth = Double.parseDouble(fields[1].trim());
            Double petalLength = Double.parseDouble(fields[2].trim());
            Double petalWidth = Double.parseDouble(fields[3].trim());
            String species = fields[4].trim();

            return new FlowerRecord(sepalLength, sepalWidth, petalLength, petalWidth, species);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
