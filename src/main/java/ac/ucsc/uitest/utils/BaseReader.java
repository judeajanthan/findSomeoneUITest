package ac.ucsc.uitest.utils;

import ac.ucsc.uitest.models.BaseDataModel;
import org.apache.poi.ss.formula.functions.T;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class BaseReader {
    private static final ObjectMapper mapper = new ObjectMapper();

    // Generic method to read a List of any Type from JSON
      protected static <T> List<BaseDataModel<T>> loadJsonData(String filePath,
                                                             TypeReference<List<BaseDataModel<T>>> typeReference) {
        return mapper.readValue(new File(filePath), typeReference);
    }

}
