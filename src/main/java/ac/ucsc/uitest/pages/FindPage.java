package ac.ucsc.uitest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindPage extends BasePage {

    private static final By FIND_A_FRIEND_BUTTON = By.xpath("//div[@class='intent-chips']//button[text()='Find a Friend']");

    private static final By STUDY_BUDDY_BUTTON = By.xpath("//div[@class='intent-chips']//button[text()='Study Buddy']");

    private static final By LOCATION_INPUT_FIELD = By.xpath("//label[text()='Location']/following-sibling::input']");

    private static final By MAIN_CATEGORY_DROPDOWN = By.xpath("//label[text()='Main category']/following-sibling::select");

    private static final By SUB_CATEGORY_DROPDOWN = By.xpath("//label[text()='Sub-category']/following-sibling::select");

    private static final By MIN_RATING_INPUT_FIELD = By.xpath("//label[text()='Min rating']/following-sibling::input");

    private static final By SEARCH_RADIUS_INPUT_FIELD = By.xpath("//label[text()='Search radius (km)']/following-sibling::input']");

    private static final By ZOOM_IN_BUTTON = By.xpath("//a[@aria-label='Zoom in']");

    private static final By ZOOM_OUT_BUTTON = By.xpath("//a[@aria-label='Zoom out']");

    private static final By MAP_CONTAINER = By.xpath("//label[text()='Search center pin']/following-sibling::div//div[contains(@class,'leaflet-container')]");

    private static final By MAP_PIN_ICON = By.xpath("//img[contains(@class,'leaflet-marker-icon')]");

    private static final By USE_MY_LOCATION_BUTTON = By.xpath("//div[@class='cluster']//button[text()='Use my location']");

    private static final By CLEAR_PIN_BUTTON = By.xpath("//div[@class='cluster']//button[text()='Clear pin']");

    private static final By PREFERRED_CURRENCY_DROPDOWN = By.xpath("//label[text()='Preferred currency']/following-sibling::select");

    private static final By MESSAGE_BUTTON = By.xpath("//div[@class='cluster']//button[text()='Message']");

    private static final By CLOSE_BUTTON = By.xpath("//a[@aria-label='Close request contact modal']");

    private static final By PURPOSE_DROPDOWN = By.xpath("//label[text()='Purpose']/following-sibling::select");

    private static final By SERVICE_INPUT_FIELD = By.xpath("//label[text()='Service']/following-sibling::input[@readonly]");

    private static final By MESSAGE_INPUT_FIELD = By.xpath("//label[text()='Message']/following-sibling::textarea");

    private static final By CANCEL_BUTTON = By.xpath("//div[@class='cluster right mt-4']//button[text()='Cancel']");

    private static final By SEND_MESSAGE_BUTTON = By.xpath("//div[@class='cluster right mt-4']//button[text()='Send message']");

    public FindPage(WebDriver driver) {
        super(driver);
    }

}