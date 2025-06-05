package service;

import analysis.StatisticsCalculator;
import data.DataSet;
import observer.DataObserver;
import observer.Observer;

import java.util.Scanner;

public class DataService {

    private DataSet dataSet = new DataSet();
    private StatisticsCalculator calculator = new StatisticsCalculator(dataSet);
    private Observer observer = new DataObserver(calculator);

    public void importData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter CSV file path: ");
        String path = scanner.nextLine();

        dataSet.loadFromCSV(path);
        dataSet.printPreview(5);
    }

    public void applyTransformation() {
        if (dataSet.getData().isEmpty()) {
            System.out.println("Please import data first!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Data Transformation ===");
        System.out.println("1. Filter");
        System.out.print("Select option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); 

        if (option == 1) {
            System.out.print("Enter column to filter: ");
            String column = scanner.nextLine();
            System.out.print("Enter value to filter: ");
            String value = scanner.nextLine();

            var transformer = factory.TransformerFactory.createFilterTransformer(column, value);
            transformer.transform(dataSet);
        } else {
            System.out.println("Invalid option.");
        }
    }

    public void performAnalysis() {
        if (dataSet.getData().isEmpty()) {
            System.out.println("Please import data first!");
            return;
        }

        System.out.println("=== Performing Analysis ===");
        observer.update();
    }

    public void exportData() {
        if (dataSet.getData().isEmpty()) {
            System.out.println("Please import data first!");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Export Data ===");
        System.out.println("1. Export to CSV");
        System.out.print("Select option: ");
        int option = scanner.nextInt();
        scanner.nextLine(); 

        if (option == 1) {
            System.out.print("Enter CSV export path: ");
            String path = scanner.nextLine();

            DataExporter exporter = new CsvExporter();
            exporter.export(dataSet, path);
        } else {
            System.out.println("Invalid option.");
        }
    }
}
