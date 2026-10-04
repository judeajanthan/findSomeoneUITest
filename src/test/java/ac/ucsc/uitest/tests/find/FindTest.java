package ac.ucsc.uitest.tests.find;

import ac.ucsc.uitest.models.SearchData;
import ac.ucsc.uitest.pages.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ac.ucsc.uitest.pages.FindPage;

public class FindTest extends FindBaseTest {

    private FindPage findPage;

    @BeforeMethod
    public void navigateToFindPage() {
        HomePage homePage = basePage.initApp();
        homePage.clickFindButton();
        findPage = PageFactory.initElements(driver, FindPage.class);
    }

    //Negative case
    @Test(description = "TC-001", dataProvider = "commonDataProvider")
    public void NoResult(SearchData testData) throws InterruptedException{
        findPage.locationInputField(testData.getInput());
        Thread.sleep(3000);
        Assert.assertEquals(findPage.validateNoResultsMessage(), testData.getExpectedNoResultMsg());
        System.out.println(findPage.validateNoResultsMessage());
    }

    //Positive cases individual filters
    @Test(description = "TC-002", dataProvider = "commonDataProvider")
    public void findByFindAFriendBtn(SearchData testData) throws InterruptedException {
        findPage.clickFindAFriendButton();
        Thread.sleep(3000);
        if (findPage.validateCardDisplayed()) {
            Assert.assertTrue(findPage.getCardCount() > 0);
            System.out.println(findPage.getCardCount());
//            Assert.assertEquals(findPage.validateMainCategoryDisplayed(), testData.getExpectedMainCategory());
//            System.out.println(findPage.validateMainCategoryDisplayed());
        }
    }

    @Test(description = "TC-003", dataProvider = "commonDataProvider")
    public void findByStudyBuddyBtn(SearchData testData) throws InterruptedException {
        findPage.clickStudyBuddyButton();
        Thread.sleep(3000);
        if (findPage.validateCardDisplayed()) {
            Assert.assertTrue(findPage.getCardCount() > 0);
            System.out.println(findPage.getCardCount());
//            Assert.assertEquals(findPage.validateMainCategoryDisplayed(), testData.getExpectedMainCategory());
//            System.out.println(findPage.validateMainCategoryDisplayed());
//            Assert.assertEquals(findPage.validateSubCategoryDisplayed(), testData.getExpectedSubCategory());
//            System.out.println(findPage.validateSubCategoryDisplayed());
        } else {
            Assert.assertEquals(findPage.validateNoResultsMessage(), testData.getExpectedNoResultMsg());
            System.out.println(findPage.validateNoResultsMessage());
        }
    }

    @Test(description = "TC-004", dataProvider = "commonDataProvider")
    public void findByLocation(SearchData testData) throws InterruptedException {
        findPage.locationInputField(testData.getInput());
        Thread.sleep(3000);
        if (findPage.validateCardDisplayed()) {
            Assert.assertTrue(findPage.getCardCount() > 0);
            System.out.println(findPage.getCardCount());
        } else {
            Assert.assertEquals(findPage.validateNoResultsMessage(), testData.getExpectedNoResultMsg());
            System.out.println(findPage.validateNoResultsMessage());
        }
    }

    @Test(description = "TC-005", dataProvider = "commonDataProvider")
    public void findByMainCat(SearchData testData) throws InterruptedException {
        findPage.selectMainCategory(testData.getSelectedMainCategory());
        Thread.sleep(3000);
        if (findPage.validateCardDisplayed()) {
            Assert.assertTrue(findPage.getCardCount() > 0);
            System.out.println(findPage.getCardCount());
            Assert.assertEquals(findPage.validateMainCategoryDisplayed(), testData.getExpectedMainCategory());
            System.out.println(findPage.validateMainCategoryDisplayed());
        } else {
            Assert.assertEquals(findPage.validateNoResultsMessage(), testData.getExpectedNoResultMsg());
            System.out.println(findPage.validateNoResultsMessage());
        }
    }

    @Test(description = "TC-006", dataProvider = "commonDataProvider")
    public void findBySubCat(SearchData testData) throws InterruptedException {
        //precondition
        findPage.scrollByPixels(0, 250);
        findPage.selectMainCategory(testData.getSelectedMainCategory());
        findPage.selectSubCategory(testData.getSelectedSubCategory());
        Thread.sleep(3000);
        if (findPage.validateCardDisplayed()) {
            Assert.assertTrue(findPage.getCardCount() > 0);
            System.out.println(findPage.getCardCount());
//            Assert.assertEquals(findPage.validateSubCategoryDisplayed(), testData.getExpectedSubCategory());
//            System.out.println(findPage.validateSubCategoryDisplayed());
        } else {
            Assert.assertEquals(findPage.validateNoResultsMessage(), testData.getExpectedNoResultMsg());
            System.out.println(findPage.validateNoResultsMessage());
        }
    }
}