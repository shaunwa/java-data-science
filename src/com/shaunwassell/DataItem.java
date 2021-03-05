package com.shaunwassell;

import java.util.List;

public interface DataItem {
    // A list of a data point's attributes, all represented as doubles
    public List<Double> getCoordinates();

    // The group label
    public String getClassLabel();
}
