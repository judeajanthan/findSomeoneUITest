package ac.ucsc.uitest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {

    //  BASIC LOCATORS

    private static final By EMAIL_FIELD =
            By.xpath("//label[text()='Email']/following-sibling::input");

    private static final By PASSWORD_FIELD =
            By.xpath("//label[text()='Password']/following-sibling::input");

    private static final By DISPLAY_NAME =
            By.xpath("//label[text()='Display name']/following-sibling::input");

    private static final By PROFILE_UPLOAD =
            By.xpath("//label[contains(text(),'Profile picture')]/following-sibling::div//input[@type='file']");

    // ROLE
    private static final By SEEKER_OPTION =
            By.xpath("//input[@value='seeker']/parent::label");

    private static final By PROFESSIONAL_OPTION =
            By.xpath("//input[@value='professional']/parent::label");

    private static final By BOTH_OPTION =
            By.xpath("//input[@value='both']/parent::label");

    // COMMON FIELDS

    private static final By CITY_FIELD =
            By.xpath("//label[text()='City']/following-sibling::input");

    private static final By BIO_TEXTAREA =
            By.xpath("//label[text()='Bio']/following-sibling::textarea");

    private static final By COUNTRY_FIELD =
            By.xpath("//label[text()='Country']/following-sibling::input");

    // PROFESSIONAL FIELDS
    //  SPECIALITIES

    private static final By CATEGORY_DROPDOWN =
            By.xpath("//label[text()='Category']/following-sibling::select");

    private static final By SUBCATEGORY_DROPDOWN =
            By.xpath("//label[text()='Sub-category']/following-sibling::select");

    private static final By ADDED_SPECIALITIES =
            By.xpath("//div[contains(@class,'speciality-panel')]//div[.//button[text()='Remove']]");

    private static final By SPECIALITY_ADDED_MESSAGE =
            By.xpath("//div[contains(@class,'speciality-panel')]//div[contains(@class,'muted')]");

    private static final By REMOVE_BUTTON =
            By.xpath("(//div[contains(@class,'speciality-panel')]//button[text()='Remove'])[1]");

    private static final By CLEAR_ALL_BUTTON =
            By.xpath("//button[text()='Clear all']");

    // EXPERIENCE & HOURLY RATE
    private static final By EXPERIENCE_FIELD =
            By.xpath("//label[contains(text(),'Experience')]/following-sibling::input");

    private static final By HOURLY_RATE_FIELD =
            By.xpath("//label[contains(text(),'Hourly rate')]/following-sibling::input");

    // PRIMARY WORK AREA & PREFERRED AREA
    private static final By PRIMARY_WORK_AREA =
            By.xpath("//label[contains(text(),'Primary work area')]/following-sibling::input");

    private static final By PREFERRED_AREA =
            By.xpath("//label[contains(text(),'Preferred surrounding areas')]/following-sibling::input");

    // RATE CURRENCY
    private static final By RATE_CURRENCY =
            By.xpath("//label[contains(text(),'Rate currency')]/following-sibling::select");

    // SERVICE RADIUS
    private static final By SERVICE_RADIUS =
            By.xpath("//label[contains(text(),'Service radius')]/following-sibling::input");

    // MAP ACTIONS
    private static final By USE_MY_LOCATION_BUTTON =
            By.xpath("//button[contains(text(),'Use my location')]");

    private static final By CLEAR_PIN_BUTTON =
            By.xpath("//button[contains(text(),'Clear pin')]");

    // CREATE ACCOUNT BUTTON

    private static final By CREATE_ACCOUNT_BUTTON =
            By.xpath("//button[text()='Create account']");

    // CONSTRUCTOR

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    // ACTION METHODS
    // BASIC ACTIONS

    public void enterEmail(String text) {
        type(EMAIL_FIELD, text);
    }

    public void enterPassword(String text) {
        type(PASSWORD_FIELD, text);
    }

    public void enterDisplayName(String text) {
        type(DISPLAY_NAME, text);
    }

    public void uploadProfilePicture(String filePath) {
        uploadFile(PROFILE_UPLOAD, filePath); // uses BasePage method
    }

    // ROLE ACTIONS
    public void selectSeeker() {
        click(SEEKER_OPTION);
    }

    public void selectProfessional() {
        click(PROFESSIONAL_OPTION);
    }

    public void selectBoth() {
        click(BOTH_OPTION);
    }
    // COMMON ACTIONS

    public void enterCity(String text) {
            type(CITY_FIELD, text);
    }

    public void enterBio(String text) {
            type(BIO_TEXTAREA, text);
    }

       // COUNTRY
       public String getCountry() {
            return getValue(COUNTRY_FIELD);
        }

    //  SPECIALITIES ACTIONS
    public void selectCategory(String value) {
        selector(CATEGORY_DROPDOWN, value);
    }

    public void selectSubCategory(String value) {
        locatorWaiting(SUBCATEGORY_DROPDOWN); // ensure enabled after category selection
        selector(SUBCATEGORY_DROPDOWN, value);
    }

    public void addSpeciality(String category, String subCategory) {
        selectCategory(category);
        selectSubCategory(subCategory);
    }

    // SPECIALITY VALIDATION
    public int getAddedSpecialitiesCount() {
        return countElements(ADDED_SPECIALITIES);
    }

    public boolean isSpecialityAdded() {
        return isElementPresent(ADDED_SPECIALITIES);
    }


    public boolean isSpecialityMessageDisplayed() {
        return isElementPresent(SPECIALITY_ADDED_MESSAGE);
    }

    // ACTION METHODS (REMOVE / CLEAR)
    public void clickRemoveFirstSpeciality() {
        click(REMOVE_BUTTON);
    }

    public void clickClearAllSpecialities() {
        click(CLEAR_ALL_BUTTON);
    }

    // EXPERIENCE & HOURLY RATE METHODS
    public void enterExperience(String value) {
        type(EXPERIENCE_FIELD, value);
    }

    public void enterHourlyRate(String value) {
        type(HOURLY_RATE_FIELD, value);
    }

    // PRIMARY WORK AREA & PREFERRED AREA METHODS
    public void enterPrimaryWorkArea(String value) {
        type(PRIMARY_WORK_AREA, value);
    }

    public void enterPreferredArea(String value) {
        type(PREFERRED_AREA, value);
    }

    // SELECT CURRENCY METHOD
    public void selectCurrency(String value) {
        selector(RATE_CURRENCY, value);
    }

    // SERVICE RADIUS METHOD
    public void enterServiceRadius(String value) {
        type(SERVICE_RADIUS, value);
    }

    // MAP ACTION METHODS
    public void clickUseMyLocation() {
        click(USE_MY_LOCATION_BUTTON);
    }

    public void clickClearPin() {
        click(CLEAR_PIN_BUTTON);
    }

    // FINAL ACTION

    public void clickCreateAccount() {
        click(CREATE_ACCOUNT_BUTTON);
    }
}