package ac.ucsc.uitest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

/**
 * @author aerok
 * @code @created 21/03/2026
 */
public class BasePage {

    private final String baseURL = "https://test.ineedtofindsomeonefor.com";

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage initApp() {
        driver.get(this.baseURL);
        return PageFactory.initElements(driver, HomePage.class);
    }

    public void scrollByPixels(int x, int y) {
        Actions actions = new Actions(driver);
        actions.scrollByAmount(x, y).perform();
    }
}
