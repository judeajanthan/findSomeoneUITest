package ac.ucsc.uitest.dataproviders;

import ac.ucsc.uitest.models.SearchData;
import ac.ucsc.uitest.utils.BaseReader;
import org.testng.annotations.DataProvider;
import tools.jackson.core.type.TypeReference;

import java.util.Iterator;
import java.util.List;

/**
 * @author aerok
 * {@code @created} 15/03/2026
 */

public class SearchDataProvider extends BaseReader {



    @DataProvider(name = "searchProvider")
    public static Iterator<Object[]> getSearchData() {
        String path = "src/main/resources/testdata/search_data.json";

        // Use Parent method
        List<SearchData> data = loadJsonData(path, new TypeReference<>() {
        });



        // Convert to Iterator
        return data.stream().map(d -> new Object[]{d}).iterator();
    }
}