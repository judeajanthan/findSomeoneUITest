package ac.ucsc.uitest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindPage extends BasePage {

    private String mainCategorySelectorVisibleText;
    private String subCategorySelectorVisibleText;
    private String preferredCurrencySelectorVisibleText;
    private String purposeSelectorVisibleText;

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

    public FindPage(WebDriver driver) {
        super(driver);
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
        selector(MAIN_CATEGORY_SELECTOR, visibleText);
        this.mainCategorySelectorVisibleText = visibleText;
    }

    public void selectSubCategory(String visibleText) {
        selector(SUB_CATEGORY_SELECTOR, visibleText);
        this.subCategorySelectorVisibleText = visibleText;
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
        this.preferredCurrencySelectorVisibleText = visibleText;
    }

    public void clickMessageButton() {
        click(MESSAGE_BUTTON);
    }

    public void clickCloseButton() {
        click(CLOSE_BUTTON);
    }

    public void clickPurposeSelector(String visibleText) {
        selector(PURPOSE_SELECTOR, visibleText);
        this.purposeSelectorVisibleText = visibleText;
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
}