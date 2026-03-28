package ac.ucsc.uitest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ac.ucsc.uitest.constants.VariableConstants.EXPLICIT_WAIT_TIME_IN_SECONDS;

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

    public void locatorWaiting(By locator) {
        try {
            Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT_TIME_IN_SECONDS));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception ex) {
            throw new RuntimeException("Locator not found : " + ex.getMessage());
        }
    }

    public void clear(By locator) {
        locatorWaiting(locator);
    }

    public void click(By locator) {
        locatorWaiting(locator);
        driver.findElement(locator).click();
    }

    public <T> T clickAndReturn(By locator, Class<T> returnPageType) {
        click(locator);
        return PageFactory.initElements(driver, returnPageType);
    }

    public void mouseHover(By locator) {
        new Actions(driver).moveToElement(driver.findElement(locator));
    }

    public void type(By locator, String text) {
        locatorWaiting(locator);
        clear(locator);
        driver.findElement(locator).sendKeys(text);
    }

    public void Selector(By locator, String text) {
        locatorWaiting(By.xpath("//option[text()='" + text + "']"));
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text.trim());
    }
}
