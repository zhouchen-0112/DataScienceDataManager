package transform;

import data.DataSet;

import java.util.Iterator;
import java.util.Map;

public class FilterTransformer implements DataTransformer {

    private String column;
    private String value;

    public FilterTransformer(String column, String value) {
        this.column = column;
        this.value = value;
    }

    @Override
    public void transform(DataSet dataSet) {
        Iterator<Map<String, String>> iterator = dataSet.getData().iterator();

        while (iterator.hasNext()) {
            Map<String, String> row = iterator.next();
            if (!row.getOrDefault(column, "").equals(value)) {
                iterator.remove();
            }
        }

        System.out.println("Filter applied: " + column + " = " + value);
        dataSet.printPreview(5);
    }
}
