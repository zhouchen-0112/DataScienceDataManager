package test;

import data.DataSet;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataSetTest {

    public void testLoadFromCSV() {
        DataSet dataSet = new DataSet();
        dataSet.loadFromCSV("sample.csv");

        assertEquals(3, dataSet.getData().size());
        assertEquals("Alice", dataSet.getData().get(0).get("name"));
    }
}