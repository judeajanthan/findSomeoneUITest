package ac.ucsc.uitest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author aerok
 * @created 15/03/2026
 */public class HomePage extends BasePage {

    private static final By FIND_BUTTON = By.xpath("//a[@href='/search' and text()='Find']");

    private static final By SEARCH_BUTTON = By.xpath("//button[text()='Search']");

    private static final By SEARCH_PLACEHOLDER = By.xpath("//input[@class='input']");

    private static final By PLUMBING_SEARCH_BUTTON = By.xpath("//div[@class='cluster']/child::button[text()='Plumbing']");

    private static final By ELECTRICAL_SEARCH_BUTTON = By.xpath("//div[@class='cluster']/child::button[text()='Electrical']");

    private static final By MATH_TUTOR_SEARCH_BUTTON = By.xpath("//div[@class='cluster']/child::button[text()='Math Tutor']");

    private static final By STUDY_BUDDY_SEARCH_BUTTON = By.xpath("//div[@class='cluster']/child::button[text()='Study Buddy']");

    private static final By BROWSE_PROFESSIONALS_BUTTON = By.xpath("//a[@aria-label='Browse professionals']");

    private static final By BROWSE_FRIENDS_BUTTON = By.xpath("//a[@aria-label='Browse friends']");

    private static final By CREATE_ACCOUNT_BUTTON = By.xpath("//a[text()='Create account']");

    private static final By JOIN_BUTTON = By.xpath("//div[@class='header-bottom']/descendant::a[text()='Join']");

    private static final By SIGN_IN_BUTTON = By.xpath("//div[@class='header-bottom']/descendant::a[text()='Sign in']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickFindButton() {
       click(FIND_BUTTON);
    }

    public void clickJoinButton() {
        click(JOIN_BUTTON);
    }

    public void clickSignInButton() {
        click(SIGN_IN_BUTTON);
    }

    public void clickBrowseProfessionalsButton() {
        click(BROWSE_PROFESSIONALS_BUTTON);
    }

    public void clickBrowseFriendsButton() {
        click(BROWSE_FRIENDS_BUTTON);
    }

    public <T> T clickSearchButton(Class<T> returnPageType) {
        return clickAndReturn(SEARCH_BUTTON, returnPageType);

    }


    public <T> T clickCreateAccountButton(Class<T> returnPageType) {
        return clickAndReturn(CREATE_ACCOUNT_BUTTON, returnPageType);
    }


    public <T> T clickPlumbingSearchButton(Class<T> returnPageType) {
        return clickAndReturn(PLUMBING_SEARCH_BUTTON, returnPageType);
    }


    public <T> T clickElectricalSearchButton(Class<T> returnPageType) {
        return clickAndReturn(ELECTRICAL_SEARCH_BUTTON, returnPageType);
    }

    public <T> T clickMathTutorSearchButton(Class<T> returnPageType)  {
        return clickAndReturn(MATH_TUTOR_SEARCH_BUTTON, returnPageType);
    }


    public <T> T clickStudyBuddySearchButton(Class<T> returnPageType) {
        return clickAndReturn(STUDY_BUDDY_SEARCH_BUTTON, returnPageType);
    }

    public void typeSearchText(String searchText) {
        driver.findElement(SEARCH_PLACEHOLDER).sendKeys(searchText);

    }



}
