package ac.ucsc.uitest.tests.home;

import ac.ucsc.uitest.base.BaseTest;
import ac.ucsc.uitest.models.SearchData;
import ac.ucsc.uitest.pages.FindPage;
import ac.ucsc.uitest.pages.HomePage;
import org.testng.annotations.Test;

public class HomeNavigationCard extends BaseTest {
    @Test(description = "TC-001")
    public void BrowseProfessional() throws InterruptedException {
        HomePage homePage = basePage.initApp();
        FindPage findPage = homePage.clickHireAProfessionBtn(FindPage.class);
        Thread.sleep(7000);
    }
    @Test(description = "TC-002")
    public void BrowseFriend() throws InterruptedException {
        HomePage homePage = basePage.initApp();
        FindPage findPage = homePage.clickFindAFriend(FindPage.class);
        Thread.sleep(7000);
    }
    @Test(description = "TC-003")
    public void CreateAccount() throws InterruptedException {
        HomePage homePage = basePage.initApp();
        FindPage findPage = homePage.clickJoinTheNetwork(FindPage.class);
        Thread.sleep(7000);
    }

}
