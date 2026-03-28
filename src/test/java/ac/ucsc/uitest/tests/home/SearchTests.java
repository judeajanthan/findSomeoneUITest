package ac.ucsc.uitest.tests.home;

import ac.ucsc.uitest.base.BaseTest;
import ac.ucsc.uitest.models.SearchData;
import ac.ucsc.uitest.pages.FindPage;
import ac.ucsc.uitest.pages.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author aerok
 * @code @created  15/03/2026
 */
public class SearchTests extends BaseTest {

    private HomePage homePage;

    @Test(description = "TC-001", dataProvider = "searchData", dataProviderClass = SearchDataProvider.class)
    public void validateUserSearch(SearchData testData) {
        // testData.getTerm() provides "Plumbing", "Math Tutor", etc.
       // homePage.searchFor(testData.getTerm());
        // Validation logic...
        System.out.println(testData.toString());
    }

    @Test(description = "TC-001", dataProvider = "searchData", dataProviderClass = SearchDataProvider.class)
    public void SearchByText(SearchData testData) throws InterruptedException {
        HomePage homePage = basePage.initApp();
        homePage.typeSearchText(testData.getSearchTerm());
        Thread.sleep(7000);
        FindPage findPage = homePage.clickSearchButton(FindPage.class);
        Thread.sleep(7000);
    }

    @Test(description = "TC-002")
    public void SearchByPlumbingButtonClick() throws InterruptedException {
        HomePage homePage = basePage.initApp();
        FindPage findPage = homePage.clickPlumbingSearchButton(FindPage.class);
        Thread.sleep(7000);
    }

    @Test(description = "TC-003")
    public void SearchByElectricalButtonClick() throws InterruptedException {
        HomePage homePage = basePage.initApp();
        FindPage findPage = homePage.clickElectricalSearchButton(FindPage.class);
        Thread.sleep(7000);
    }

    @Test(description = "TC-004")
    public void SearchByStudyBuddyButtonClick() throws InterruptedException {
        HomePage homePage = basePage.initApp();
        FindPage findPage = homePage.clickStudyBuddySearchButton(FindPage.class);
        Thread.sleep(7000);
    }

    @Test(description = "TC-005")
    public void SearchByMathTutorButtonClick() throws InterruptedException {
        HomePage homePage = basePage.initApp();
        FindPage findPage = homePage.clickMathTutorSearchButton(FindPage.class);
        Thread.sleep(7000);
    }




}
