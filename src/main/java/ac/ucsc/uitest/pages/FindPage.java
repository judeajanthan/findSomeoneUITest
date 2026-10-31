package ac.ucsc.uitest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindPage extends BasePage {

    private static final By FIND_A_FRIEND_BUTTON = By.xpath("//div[@class='intent-chips']//button[text()='Find a Friend']");

    private static final By STUDY_BUDDY_BUTTON = By.xpath("//div[@class='intent-chips']//button[text()='Study Buddy']");

    private static final By LOCATION_INPUT_FIELD = By.xpath("//label[text()='Location']/following-sibling::input");

    private static final By MAIN_CATEGORY_SELECTOR = By.xpath("//label[text()='Main category']/following-sibling::select");

    private static final By SUB_CATEGORY_SELECTOR = By.xpath("//label[text()='Sub-category']/following-sibling::select");

    private static final By MIN_RATING_INPUT_FIELD = By.xpath("//label[text()='Min rating']/following-sibling::input");

    private static final By SEARCH_RADIUS_INPUT_FIELD = By.xpath("//label[text()='Search radius (km)']/following-sibling::input");

    private static final By ZOOM_IN_BUTTON = By.xpath("//a[@aria-label='Zoom in']");

    private static final By ZOOM_OUT_BUTTON = By.xpath("//a[@aria-label='Zoom out']");

    private static final By MAP_CONTAINER = By.xpath("//label[text()='Search center pin']/following-sibling::div//div[contains(@class,'leaflet-container')]");

    private static final By MAP_PIN_ICON = By.xpath("//img[contains(@class,'leaflet-marker-icon')]");

    private static final By USE_MY_LOCATION_BUTTON = By.xpath("//div[@class='cluster']//button[text()='Use my location']");

    private static final By CLEAR_PIN_BUTTON = By.xpath("//div[@class='cluster']//button[text()='Clear pin']");

    private static final By PREFERRED_CURRENCY_SELECTOR = By.xpath("//label[text()='Preferred currency']/following-sibling::select");

    private static final By MESSAGE_BUTTON = By.xpath("//div[@class='cluster']//button[text()='Message']");

    private static final By CLOSE_BUTTON = By.xpath("//a[@aria-label='Close request contact modal']");

    private static final By PURPOSE_SELECTOR = By.xpath("//label[text()='Purpose']/following-sibling::select");

    private static final By SERVICE_INPUT_FIELD = By.xpath("//label[text()='Service']/following-sibling::input[@readonly]");

    private static final By MESSAGE_INPUT_FIELD = By.xpath("//label[text()='Message']/following-sibling::textarea");

    private static final By CANCEL_BUTTON = By.xpath("//div[@class='cluster right mt-4']//button[text()='Cancel']");

    private static final By SEND_MESSAGE_BUTTON = By.xpath("//div[@class='cluster right mt-4']//button[text()='Send message']");

    private static final By NO_RESULTS_MESSAGE = By.xpath("//div[@class='card' and normalize-space()='No results. Try widening your filters.']");

    private static final By RESULTS_CARD = By.xpath("//div[@class='card stack-sm']");

    public FindPage(WebDriver driver) {
        super(driver);
    }

    public void waitForSearchOutcome() {
        waitForVisibleOutcome(RESULTS_CARD, NO_RESULTS_MESSAGE);
    }

    public void clickFindAFriendButton() {
        click(FIND_A_FRIEND_BUTTON);
    }

    public void clickStudyBuddyButton() {
        click(STUDY_BUDDY_BUTTON);
    }

    public void locationInputField(String text) {
        type(LOCATION_INPUT_FIELD, text);
    }

    public void selectMainCategory(String visibleText) {
        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );

        wait.until(d -> {
            try {
                Select select = new Select(
                        d.findElement(MAIN_CATEGORY_SELECTOR)
                );

                boolean optionExists = select.getOptions().stream()
                        .anyMatch(option ->
                                option.getText().trim()
                                        .equals(visibleText.trim())
                        );

                if (!optionExists) {
                    return false;
                }

                // Select using the freshly located dropdown.
                select.selectByVisibleText(visibleText.trim());

                return true;

            } catch (NoSuchElementException |
                     StaleElementReferenceException e) {
                // Retry if the dropdown or its options change.
                return false;
            }
        });
    }

    public void selectSubCategory(String visibleText) {
        selector(SUB_CATEGORY_SELECTOR, visibleText);
    }

    public void clickMinRatingInputField(String text) {
        type(MIN_RATING_INPUT_FIELD, text);
    }

    public void clickSearchRadiusInputField(String text) {
        type(SEARCH_RADIUS_INPUT_FIELD, text);
    }

    public void clickZoomInButton() {
        click(ZOOM_IN_BUTTON);
    }

    public void clickZoomOutButton() {
        click(ZOOM_OUT_BUTTON);
    }

    public void clickMapContainer() {
        click(MAP_CONTAINER);
    }

    public void clickMapPinIcon() {
        click(MAP_PIN_ICON);
    }

    public void clickUseMyLocationButton() {
        click(USE_MY_LOCATION_BUTTON);
    }

    public void clickClearPinButton() {
        click(CLEAR_PIN_BUTTON);
    }

    public void clickPreferredCurrencySelector(String visibleText) {
        selector(PREFERRED_CURRENCY_SELECTOR, visibleText);
    }

    public void clickMessageButton() {
        click(MESSAGE_BUTTON);
    }

    public void clickCloseButton() {
        click(CLOSE_BUTTON);
    }

    public void clickPurposeSelector(String visibleText) {
        selector(PURPOSE_SELECTOR, visibleText);
    }

    public void clickServiceInputField(String text) {
        type(SERVICE_INPUT_FIELD, text);
    }

    public void clickMessageInputField(String text) {
        type(MESSAGE_INPUT_FIELD, text);
    }

    public void clickCancelButton() {
        click(CANCEL_BUTTON);
    }

    public void clickSendMessageButton() {
        click(SEND_MESSAGE_BUTTON);
    }

    // Expected result functions

    public boolean validateCardDisplayed() {
        return !driver.findElements(RESULTS_CARD).isEmpty();
    }

    public int getCardCount() {
        return driver.findElements(RESULTS_CARD).size();
    }

    public String validateMainCategoryDisplayed() {
        return new Select(
                driver.findElement(MAIN_CATEGORY_SELECTOR)
        ).getFirstSelectedOption().getText().trim();
    }

    public String validateSubCategoryDisplayed() {
        return new Select(
                driver.findElement(SUB_CATEGORY_SELECTOR)
        ).getFirstSelectedOption().getText().trim();
    }

    public String validatePreferredCurrencyDisplayed() {
        return new Select(
                driver.findElement(PREFERRED_CURRENCY_SELECTOR)
        ).getFirstSelectedOption().getText().trim();
    }

    public String validateNoResultsMessage() {
        return text(NO_RESULTS_MESSAGE);
    }

    public void waitForNoResultsMessage() {
        locatorWaiting(NO_RESULTS_MESSAGE);
    }
}