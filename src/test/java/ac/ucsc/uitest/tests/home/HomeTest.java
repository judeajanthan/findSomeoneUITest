package ac.ucsc.uitest.tests.home;


import ac.ucsc.uitest.pages.FindPage;
import ac.ucsc.uitest.pages.HomePage;
import ac.ucsc.uitest.tests.BaseTest;
import ac.ucsc.uitest.tests.SignUp.SignUpTest;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @Test(description = "TC-001")
    public void clickFindBtn() {
        HomePage homePage = basePage.initApp();
        homePage.clickFindButton();
    }

    @Test(description = "TC-002")
    public void clickBrowseProfessionalsBtn() {
        HomePage homePage = basePage.initApp();
        homePage.clickBrowseProfessionalsButton();
    }

    @Test(description = "TC-003")
    public void clickBrowseFriendsBtn() {
        HomePage homePage = basePage.initApp();
        homePage.clickBrowseFriendsButton();
    }

//    @Test(description = "TC-004")
//    public void ClickCreateAccount() throws InterruptedException {
//        HomePage homePage = basePage.initApp();
//        FindPage findPage = homePage.clickCreateAccountButton(SignUpTest.class);
//        Thread.sleep(7000);
//    }
}
