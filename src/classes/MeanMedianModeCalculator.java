package classes;

import java.util.*;

public class MeanMedianModeCalculator {
    private double[] data;

    public MeanMedianModeCalculator(double[] inputData) {
        this.data = inputData;
    }

    public double calculateMean() {
        double sum = 0;
        for (double num : data) {
            sum += num;
        }
        return sum / data.length;
    }

    public double calculateMedian() {
        double median;
        Arrays.sort(data);

        if (data.length % 2 == 0) {
            median = (data[data.length / 2 - 1] + data[data.length / 2]) / 2.0;
        } else {
            median = data[data.length / 2];
        }
        return median;
    }

    public double[] calculateMode() {
        Map<Double, Integer> frequencyMap = new HashMap<>();

        for (double num : data) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = frequencyMap.values().stream().mapToInt(frequency -> frequency).filter(frequency -> frequency >= 0).max().orElse(0);

        if (maxFrequency <= 1) {
            return new double[0]; // If all values occur only once, there is no mode
        }

        // Find values with the maximum frequency (mode)
        return frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .mapToDouble(Map.Entry::getKey)
                .toArray();
    }
}