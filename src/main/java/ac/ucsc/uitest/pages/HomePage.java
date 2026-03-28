package ac.ucsc.uitest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author aerok
 * @created 15/03/2026
 */public class HomePage extends BasePage {

    private static final By FIND_BUTTON = By.xpath("//a[@href='/search' and text()='Find']");

    private static final By PLUMBING_SEARCH_BUTTON = By.xpath("//div[@class='cluster']/child::button[text()='Plumbing']");

    private static final By ELECTRICAL_SEARCH_BUTTON = By.xpath("//div[@class='cluster']/child::button[text()='Electrical']");

    private static final By MATH_TUTOR_SEARCH_BUTTON = By.xpath("//div[@class='cluster']/child::button[text()='Math Tutor']");

    private static final By STUDY_BUDDY_SEARCH_BUTTON = By.xpath("//div[@class='cluster']/child::button[text()='Study Buddy']");

    private static final By BROWSE_PROFESSIONALS_BUTTON = By.xpath("//a[@aria-label='Browse professionals']");

    private static final By BROWSE_FRIENDS_BUTTON = By.xpath("//a[@aria-label='Browse friends']");

    private static final By CREATE_ACCOUNT_BUTTON = By.xpath("//a[text()='Create account']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickFindButton() {
       click(FIND_BUTTON);
    }

    public void clickBrowseProfessionalsButton() {
        click(BROWSE_PROFESSIONALS_BUTTON);
    }

    public void clickBrowseFriendsButton() {
       click(BROWSE_FRIENDS_BUTTON);
    }
}
