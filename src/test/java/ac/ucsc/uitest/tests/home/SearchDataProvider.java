package ac.ucsc.uitest.tests.home;

import ac.ucsc.uitest.models.SearchData;
import ac.ucsc.uitest.utils.BaseReader;
import org.testng.annotations.DataProvider;
import tools.jackson.core.type.TypeReference;

import java.util.Iterator;
import java.util.List;


/**
 * @author aerok
 * {@code @created} 15/03/2026
 */public class SearchDataProvider extends BaseReader {


    @DataProvider(name = "searchData")
    public static Iterator<Object[]> getSearchData() {
        String filePath = "src/main/resources/testdata/search_data.json";
        List<SearchData> data = loadJsonData(filePath,
                new TypeReference<List<SearchData>>() {});
        return data.stream().map(d -> new Object[]{d}).iterator();
    }
}
