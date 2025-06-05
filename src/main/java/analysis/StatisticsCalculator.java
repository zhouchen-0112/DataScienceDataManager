package analysis;

import data.DataSet;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticsCalculator {

    private DataSet dataSet;

    public StatisticsCalculator(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    public void calculate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter column to analyze: ");
        String column = scanner.nextLine();

        List<Double> values = dataSet.getData().stream()
                .map(row -> row.getOrDefault(column, ""))
                .filter(val -> !val.isEmpty())
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        if (values.isEmpty()) {
            System.out.println("No valid numeric data found.");
            return;
        }

        double mean = values.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

        Collections.sort(values);
        double median = values.size() % 2 == 0 ?
                (values.get(values.size() / 2 - 1) + values.get(values.size() / 2)) / 2 :
                values.get(values.size() / 2);

        Map<Double, Long> freqMap = values.stream()
                .collect(Collectors.groupingBy(v -> v, Collectors.counting()));

        double mode = freqMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(Double.NaN);

        System.out.printf("Mean: %.2f, Median: %.2f, Mode: %.2f\n", mean, median, mode);
    }
}
