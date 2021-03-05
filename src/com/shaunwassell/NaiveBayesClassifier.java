package com.shaunwassell;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.stat.StatUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NaiveBayesClassifier {
    private List<DataItem> dataPoints;

    public NaiveBayesClassifier() {
        this.dataPoints = new ArrayList<>();
    }

    public void addDataPoint(DataItem dataPoint) {
        this.dataPoints.add(dataPoint);
    }

    private List<Double> getColumnMeans(List<DataItem> dataPoints) {
        List<Double> columnMeans = new ArrayList<>();
        for (int i = 0; i < dataPoints.get(0).getCoordinates().size(); i++) {
            int j = i;
            Double columnMean = StatUtils.mean(
                    dataPoints.stream()
                        .map(point -> point.getCoordinates().get(j))
                        .mapToDouble(Double::doubleValue)
                        .toArray()
            );
            columnMeans.add(columnMean);
        }

        return columnMeans;
    }

    private List<Double> getColumnStdDevs(List<DataItem> dataPoints) {
        List<Double> columnStdDevs = new ArrayList<>();
        for (int i = 0; i < dataPoints.get(0).getCoordinates().size(); i++) {
            int j = i;
            Double columnVariance = StatUtils.variance(
                    dataPoints.stream()
                            .map(point -> point.getCoordinates().get(j))
                            .mapToDouble(Double::doubleValue)
                            .toArray()
            );
            columnStdDevs.add(Math.sqrt(columnVariance));
        }

        return columnStdDevs;
    }

    private Double getLabelProbabilityForPoint(List<Double> groupsColumnMeans, List<Double> groupsColumnStdDevs, DataItem point) {
        Double probability = 1.0;
        for (int i = 0; i < groupsColumnMeans.size(); i++) {
            Double mean = groupsColumnMeans.get(i);
            Double stdDev = groupsColumnStdDevs.get(i);
            Double pointValue = point.getCoordinates().get(i);
            NormalDistribution dist = new NormalDistribution(mean, stdDev);
            probability *= dist.cumulativeProbability(pointValue);
        }
        return probability;
    }

    public Map<String, Double> classifyPoint(DataItem unlabelledPoint) {
        List<String> allLabels = new ArrayList<>(
                this.dataPoints.stream()
                    .map(point -> point.getClassLabel())
                    .collect(Collectors.toSet())
        );

        Map<String, Double> probabilities = new HashMap<>();

        for (String label : allLabels) {
            List<DataItem> dataPointsForLabel = this.dataPoints.stream()
                    .filter(point -> point.getClassLabel().equals(label))
                    .collect(Collectors.toList());

            List<Double> groupColumnMeans = getColumnMeans(dataPointsForLabel);
            List<Double> groupStdDevs = getColumnStdDevs(dataPointsForLabel);

            probabilities.put(
                    label,
                    getLabelProbabilityForPoint(groupColumnMeans, groupStdDevs, unlabelledPoint)
            );
        }

        return probabilities;
    }
}
