package com.shaunwassell;

import java.util.*;
import java.util.stream.Collectors;

public class KNNClassifier {
    List<DataItem> dataPoints;

    static class Pair<K, V> {
        public final K k;
        public final V v;

        public Pair(K k, V v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "k=" + k +
                    ", v=" + v +
                    '}';
        }
    }

    public KNNClassifier() {
        this.dataPoints = new ArrayList<>();
    }

    public void addDataPoint(DataItem dataPoint) {
        this.dataPoints.add(dataPoint);
    }


    /*
        Iris-versicolor=3
        Iris-setosa=2
     */
    private Map<String, Integer> countOccurrences(List<String> list) {
        Map<String, Integer> occurrences = new HashMap<>();
        for (String label : list) {
            Integer currentCount = occurrences.get(label);
            occurrences.put(label, (currentCount == null) ? 1 : currentCount + 1);
        }
        return occurrences;
    }

    public Map<String, Integer> classifyPoint(DataItem unlabelledPoint, Integer numberOfNeighbors) {
        List<Pair<Double, String>> pointDistances = this.dataPoints.stream()
                .map(point -> new Pair<>(DataItemUtil.getDistance(point, unlabelledPoint), point.getClassLabel()))
                .collect(Collectors.toList());
        Collections.sort(pointDistances, new Comparator<Pair<Double, String>>() {
            @Override
            public int compare(Pair<Double, String> o1, Pair<Double, String> o2) {
                if (o1.k < o2.k) return -1;
                if (o1.k > o2.k) return 1;
                return 0;
            }
        });

        List<String> closestLabels = pointDistances
                .subList(0, Math.min(pointDistances.size(), numberOfNeighbors))
                .stream()
                .map(pair -> pair.v)
                .collect(Collectors.toList());

        return countOccurrences(closestLabels);
    }
}
