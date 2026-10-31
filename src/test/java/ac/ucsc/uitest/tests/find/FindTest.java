package ac.ucsc.uitest.tests.find;

import ac.ucsc.uitest.models.SearchData;
import ac.ucsc.uitest.pages.FindPage;
import ac.ucsc.uitest.pages.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindTest extends FindBaseTest {

    private FindPage findPage;

    @BeforeMethod
    public void navigateToFindPage() {
        HomePage homePage = basePage.initApp();
        homePage.clickFindButton();
        findPage = PageFactory.initElements(driver, FindPage.class);
    }

    // Negative case
    @Test(description = "TC-001", dataProvider = "commonDataProvider")
    public void NoResult(SearchData testData) {
        findPage.locationInputField(testData.getInput());

        Assert.assertEquals(
                findPage.validateNoResultsMessage(),
                testData.getExpectedNoResultMsg(),
                "The expected no-results message was not displayed."
        );
    }

    // Positive case: Find a Friend
    @Test(description = "TC-002", dataProvider = "commonDataProvider")
    public void findByFindAFriendBtn(SearchData testData) {
        findPage.clickFindAFriendButton();
        findPage.waitForSearchOutcome();

        if (findPage.validateCardDisplayed()) {
            Assert.assertTrue(
                    findPage.getCardCount() > 0,
                    "Expected at least one result card."
            );
        } else {
            Assert.assertEquals(
                    findPage.validateNoResultsMessage(),
                    testData.getExpectedNoResultMsg(),
                    "Neither result cards nor the expected no-results message appeared."
            );
        }
    }

    // Positive case: Study Buddy
    @Test(description = "TC-003", dataProvider = "commonDataProvider")
    public void findByStudyBuddyBtn(SearchData testData) {
        findPage.clickStudyBuddyButton();
        findPage.waitForSearchOutcome();

        if (findPage.validateCardDisplayed()) {
            Assert.assertTrue(
                    findPage.getCardCount() > 0,
                    "Expected at least one result card."
            );
        } else {
            Assert.assertEquals(
                    findPage.validateNoResultsMessage(),
                    testData.getExpectedNoResultMsg(),
                    "Neither result cards nor the expected no-results message appeared."
            );
        }
    }

    // Location filter
    @Test(description = "TC-004", dataProvider = "commonDataProvider")
    public void findByLocation(SearchData testData) {
        findPage.locationInputField(testData.getInput());
        findPage.waitForSearchOutcome();

        if (findPage.validateCardDisplayed()) {
            Assert.assertTrue(
                    findPage.getCardCount() > 0,
                    "Expected at least one result card."
            );
        } else {
            Assert.assertEquals(
                    findPage.validateNoResultsMessage(),
                    testData.getExpectedNoResultMsg()
            );
        }
    }

    // Main category filter
    @Test(description = "TC-005", dataProvider = "commonDataProvider")
    public void findByMainCat(SearchData testData) {
        findPage.selectMainCategory(testData.getSelectedMainCategory());

        Assert.assertEquals(
                findPage.validateMainCategoryDisplayed(),
                testData.getExpectedMainCategory(),
                "The selected main category does not match the expected category."
        );

        findPage.waitForSearchOutcome();

        if (findPage.validateCardDisplayed()) {
            Assert.assertTrue(
                    findPage.getCardCount() > 0,
                    "Expected at least one result card."
            );
        } else {
            Assert.assertEquals(
                    findPage.validateNoResultsMessage(),
                    testData.getExpectedNoResultMsg()
            );
        }
    }

    // Sub-category filter
    @Test(description = "TC-006", dataProvider = "commonDataProvider")
    public void findBySubCat(SearchData testData) {
        // Precondition: select the main category first.
        findPage.scrollByPixels(0, 250);
        findPage.selectMainCategory(testData.getSelectedMainCategory());
        findPage.selectSubCategory(testData.getSelectedSubCategory());

        Assert.assertEquals(
                findPage.validateSubCategoryDisplayed(),
                testData.getExpectedSubCategory(),
                "The selected sub-category does not match the expected sub-category."
        );

        findPage.waitForSearchOutcome();

        if (findPage.validateCardDisplayed()) {
            Assert.assertTrue(
                    findPage.getCardCount() > 0,
                    "Expected at least one result card."
            );
        } else {
            Assert.assertEquals(
                    findPage.validateNoResultsMessage(),
                    testData.getExpectedNoResultMsg()
            );
        }
    }
}