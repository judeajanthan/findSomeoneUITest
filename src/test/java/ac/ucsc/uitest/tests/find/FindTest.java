package ac.ucsc.uitest.tests.find;

import ac.ucsc.uitest.base.BaseTest;
import ac.ucsc.uitest.models.FindData;
import ac.ucsc.uitest.pages.FindPage;
import ac.ucsc.uitest.pages.HomePage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FindTest extends BaseTest {

    private FindPage findPage;

    @BeforeMethod
    public void navigateToFindPage() {
        HomePage homePage = basePage.initApp();
        homePage.clickFindButton();
        findPage = PageFactory.initElements(driver, FindPage.class);
    }

    @Test
    public void clickFindAFriendBtn() {
        findPage.clickFindAFriendButton();
    }

    @Test (dataProvider = "locationData", dataProviderClass = FindDataProvider.class)
    public void insertLocation(FindData locationInput) {
        findPage.locationInputField(locationInput.getLocationInput());
        System.out.println(locationInput);
    }

    @Test (dataProvider = "mainCategoryData", dataProviderClass = FindDataProvider.class)
    public void selectMainCat(FindData MainCategory) {

        findPage.selectMainCategory(MainCategory.getMainCategorySelect());
        System.out.println(MainCategory);
    }
}
