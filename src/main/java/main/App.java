package main;

import service.DataService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        DataService dataService = new DataService();
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            System.out.println("\n=== Data Science Data Manager ===");
            System.out.println("1. Import Data (CSV/JSON)");
            System.out.println("2. Apply Data Transformation");
            System.out.println("3. Perform Data Analysis");
            System.out.println("4. Export Data (CSV/JSON)");
            System.out.println("5. Exit");
            System.out.print("Select option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> dataService.importData();
                case 2 -> dataService.applyTransformation();
                case 3 -> dataService.performAnalysis();
                case 4 -> dataService.exportData();
                case 5 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
