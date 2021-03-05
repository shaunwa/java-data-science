package com.shaunwassell;

import java.util.Arrays;
import java.util.List;

public class FlowerRecord implements DataItem {
    public final Double sepalLength;
    public final Double sepalWidth;
    public final Double petalLength;
    public final Double petalWidth;
    public final String species;

    public FlowerRecord(Double sepalLength, Double sepalWidth, Double petalLength, Double petalWidth, String species) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.species = species;
    }

    @Override
    public String toString() {
        return "FlowerRecord{" +
                "sepalLength=" + sepalLength +
                ", sepalWidth=" + sepalWidth +
                ", petalLength=" + petalLength +
                ", petalWidth=" + petalWidth +
                ", species='" + species + '\'' +
                '}';
    }

    @Override
    public List<Double> getCoordinates() {
        return Arrays.asList(this.sepalLength, this.sepalWidth, this.petalLength, this.petalWidth);
    }

    @Override
    public String getClassLabel() {
        return this.species;
    }
}
