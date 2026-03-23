package ac.ucsc.uitest.base;

import ac.ucsc.uitest.pages.HomePage;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest{

    @Test
    public void clickFindBtn() {
        HomePage homePage = basePage.initApp();
        homePage.clickFindButton();
    }

    @Test
    public void clickBrowseProfessionalsBtn() {
        HomePage homePage = basePage.initApp();
        homePage.clickBrowseProfessionalsButton();
    }

    @Test
    public void clickBrowseFriendsBtn() {
        HomePage homePage = basePage.initApp();
        homePage.clickBrowseFriendsButton();
    }
}
