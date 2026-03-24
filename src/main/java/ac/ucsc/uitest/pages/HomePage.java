package ac.ucsc.uitest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author aerok
 * @created 15/03/2026
 */public class HomePage extends BasePage {

    private static final By FIND_BUTTON = By.xpath("//a[@href='/search' and text()='Find']");

    private static final By BROWSE_PROFESSIONALS_BUTTON = By.xpath("//a[@aria-label='Browse professionals']");

    private static final By BROWSE_FRIENDS_BUTTON = By.xpath("//a[@aria-label='Browse friends']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickFindButton() {
        driver.findElement(FIND_BUTTON).click();
    }

    public void clickBrowseProfessionalsButton() {
        driver.findElement(BROWSE_PROFESSIONALS_BUTTON).click();
    }

    public void clickBrowseFriendsButton() {
        driver.findElement(BROWSE_FRIENDS_BUTTON).click();
    }
}
