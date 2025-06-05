package service;

import com.opencsv.CSVWriter;
import data.DataSet;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CsvExporter implements DataExporter {

    public void export(DataSet dataSet, String path) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path))) {
            writer.writeNext(dataSet.getColumns().toArray(new String[0]));

            for (Map<String, String> row : dataSet.getData()) {
                List<String> values = dataSet.getColumns().stream()
                        .map(col -> row.getOrDefault(col, ""))
                        .toList();
                writer.writeNext(values.toArray(new String[0]));
            }

            System.out.println("Data exported to CSV: " + path);

        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }
}