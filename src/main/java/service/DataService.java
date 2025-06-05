package service;

import data.DataSet;
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
        System.out.println("Applying data transformation... (功能开发中)");
    }

    public void performAnalysis() {
        System.out.println("Performing data analysis... (功能开发中)");
    }

    public void exportData() {
        System.out.println("Exporting data... (功能开发中)");
    }
}
