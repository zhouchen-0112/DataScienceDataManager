package data;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DataSet {

    private List<Map<String, String>> data = new ArrayList<>();
    private List<String> columns = new ArrayList<>();

    public void loadFromCSV(String path) {
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            List<String[]> rows = reader.readAll();

            if (rows.isEmpty()) {
                System.out.println("CSV file is empty.");
                return;
            }

            columns = Arrays.asList(rows.get(0)); // First row = header

            for (int i = 1; i < rows.size(); i++) {
                String[] row = rows.get(i);
                Map<String, String> rowMap = new LinkedHashMap<>();
                for (int j = 0; j < columns.size(); j++) {
                    rowMap.put(columns.get(j), j < row.length ? row[j] : "");
                }
                data.add(rowMap);
            }

            System.out.println("CSV loaded successfully. Rows: " + data.size());

        } catch (IOException | CsvException e) {
            System.err.println("Error reading CSV: " + e.getMessage());
        }
    }

    public void printPreview(int limit) {
        System.out.println("=== Data Preview ===");
        for (int i = 0; i < Math.min(limit, data.size()); i++) {
            System.out.println(data.get(i));
        }
    }

    public List<Map<String, String>> getData() {
        return data;
    }

    public List<String> getColumns() {
        return columns;
    }
}
