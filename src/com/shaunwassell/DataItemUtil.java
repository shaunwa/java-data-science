package com.shaunwassell;

import java.util.List;

public class DataItemUtil {
    public static Double getDistance(DataItem item1, DataItem item2) {
        List<Double> item1Coords = item1.getCoordinates();
        List<Double> item2Coords = item2.getCoordinates();

        // a^2 = b^2 + c^2 + d^2 --> a = sqrt(b^2 + c^2 + d^2)
        Double sum = 0.0;
        for (int i = 0; i < item1Coords.size(); i++) {
            Double dimensionDistance = item2Coords.get(i) - item1Coords.get(i);
            sum += dimensionDistance * dimensionDistance;
        }

        return Math.sqrt(sum);
    }
}
