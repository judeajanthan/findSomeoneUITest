package ac.ucsc.uitest.base;

import ac.ucsc.uitest.pages.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

/**
 * @author aerok
 * {@code @created} 15/03/2026
 */public class BaseTest {

    protected WebDriver driver;
    protected BasePage basePage;

    @BeforeClass
    public void setupBrowser() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        basePage = PageFactory.initElements(driver, BasePage.class);
    }

     @AfterClass
    public void quitBrowser() {
        driver.quit();
    }
}
