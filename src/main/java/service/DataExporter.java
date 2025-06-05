package service;

import data.DataSet;

public interface DataExporter {
    void export(DataSet dataSet, String path);
}