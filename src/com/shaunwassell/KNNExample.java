package com.shaunwassell;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KNNExample {
    public static void main(String[] args) {
        List<String> lines = TextLoader.getLines("iris.data");
        List<FlowerRecord> flowers = lines.stream()
                .map(line -> FlowerRecordUtil.parseFlower(line))
                .filter(flower -> flower != null)
                .collect(Collectors.toList());

        KNNClassifier classifier = new KNNClassifier();

        flowers.stream().forEach(flower -> classifier.addDataPoint(flower));

        FlowerRecord testFlower = new FlowerRecord(5.7, 2.9, 4.2, 1.3, "?");

        Map<String, Integer> counts = classifier.classifyPoint(testFlower, 100);

        System.out.println(counts);
    }
}
