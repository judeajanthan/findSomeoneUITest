package ac.ucsc.uitest.tests.find;

import ac.ucsc.uitest.models.FindData;
import ac.ucsc.uitest.utils.BaseReader;
import org.testng.annotations.DataProvider;
import tools.jackson.core.type.TypeReference;

import java.util.Iterator;
import java.util.List;


public class FindDataProvider extends BaseReader {

    private static final String filePath = "src/main/resources/testdata/find_data.json";

    @DataProvider(name = "locationData")
    public static Iterator<Object[]> getLocationData() {

        List<FindData> data = loadJsonData(filePath, new TypeReference<List<FindData>>() {});

        return data.stream()
                .filter(d -> d.getLocationInput() != null)
                .map(d -> new Object[]{d})
                .iterator();
    }

    @DataProvider(name = "mainCategoryData")
    public static Iterator<Object[]> getMainCategoryData() {

        List<FindData> data = loadJsonData(filePath, new TypeReference<List<FindData>>() {});

        return data.stream().filter(d -> d.getMainCategorySelect() != null).map(d -> new Object[]{d}).iterator();
    }
}



