package ac.ucsc.uitest.tests.home;

import ac.ucsc.uitest.base.BaseTest;
import ac.ucsc.uitest.models.SearchData;
import org.testng.annotations.Test;

/**
 * @author aerok
 * @created 15/03/2026
 */
public class SearchTests extends BaseTest {

    @Test(dataProvider = "searchData", dataProviderClass = SearchDataProvider.class)
    public void validateUserSearch(SearchData testData) {
        // testData.getTerm() provides "Plumbing", "Math Tutor", etc.
       // homePage.searchFor(testData.getTerm());
        // Validation logic...
        System.out.println(testData.toString());
    }
}
