package factory;

import transform.DataTransformer;
import transform.FilterTransformer;

public class TransformerFactory {

    public static DataTransformer createFilterTransformer(String column, String value) {
        return new FilterTransformer(column, value);
    }
}

