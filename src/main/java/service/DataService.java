package service;

import data.DataSet;
import factory.TransformerFactory;
import transform.DataTransformer;

import java.util.Scanner;

public class DataService {

    private DataSet dataSet = new DataSet();

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
        scanner.nextLine(); // consume newline

        if (option == 1) {
            System.out.print("Enter column to filter: ");
            String column = scanner.nextLine();
            System.out.print("Enter value to filter: ");
            String value = scanner.nextLine();

            DataTransformer transformer = TransformerFactory.createFilterTransformer(column, value);
            transformer.transform(dataSet);
        } else {
            System.out.println("Invalid option.");
        }
    }

    public void performAnalysis() {
        System.out.println("Performing data analysis... (功能开发中)");
    }

    public void exportData() {
        System.out.println("Exporting data... (功能开发中)");
    }
}

