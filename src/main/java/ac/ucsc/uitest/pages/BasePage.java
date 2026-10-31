package ac.ucsc.uitest.pages;

import ac.ucsc.uitest.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage initApp() {
        driver.get(ConfigReader.getBaseUrl());
        return PageFactory.initElements(driver, HomePage.class);
    }

    public void scrollByPixels(int x, int y) {
        new Actions(driver)
                .scrollByAmount(x, y)
                .perform();
    }

    public void locatorWaiting(By locator) {
        try {
            new WebDriverWait(
                    driver,
                    Duration.ofSeconds(ConfigReader.getExplicitWaitSeconds())
            ).until(ExpectedConditions.visibilityOfElementLocated(locator));

        } catch (org.openqa.selenium.TimeoutException e) {
            throw new org.openqa.selenium.TimeoutException(
                    "Element was not visible within the configured wait: "
                            + locator,
                    e
            );
        }
    }

    public void clear(By locator) {
        locatorWaiting(locator);
        driver.findElement(locator).clear();
    }

    public void click(By locator) {
        new WebDriverWait(
                driver,
                Duration.ofSeconds(ConfigReader.getExplicitWaitSeconds())
        ).until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public <T> T clickAndReturn(By locator, Class<T> returnPageType) {
        click(locator);
        return PageFactory.initElements(driver, returnPageType);
    }

    public void mouseHover(By locator) {
        locatorWaiting(locator);
        new Actions(driver)
                .moveToElement(driver.findElement(locator))
                .perform();
    }

    public void type(By locator, String text) {
        clear(locator);
        driver.findElement(locator).sendKeys(text);
    }

    public void selector(By locator, String text) {
        locatorWaiting(locator);

        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text.trim());
    }

    // Common result-reading methods
    public String text(By locator) {
        locatorWaiting(locator);
        return driver.findElement(locator).getText().trim();
    }

    public void uploadFile(By locator, String filePath) {
        locatorWaiting(locator);
        driver.findElement(locator).sendKeys(filePath);
    }

    public String getValue(By locator) {
        locatorWaiting(locator);
        return driver.findElement(locator).getAttribute("value");
    }

    public int countElements(By locator) {
        return driver.findElements(locator).size();
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    public By waitForAnyElement(By... locators) {
        return new WebDriverWait(
                driver,
                Duration.ofSeconds(ConfigReader.getExplicitWaitSeconds())
        ).until(d -> {
            for (By locator : locators) {
                if (!d.findElements(locator).isEmpty()) {
                    return locator;
                }
            }
            return null;
        });
    }

    public By waitForVisibleOutcome(By... locators) {
        return new WebDriverWait(
                driver,
                Duration.ofSeconds(ConfigReader.getExplicitWaitSeconds())
        ).until(d -> {
            for (By locator : locators) {
                if (!d.findElements(locator).isEmpty()) {
                    boolean visible = d.findElements(locator)
                            .stream()
                            .anyMatch(element -> {
                                try {
                                    return element.isDisplayed();
                                } catch (StaleElementReferenceException e) {
                                    return false;
                                }
                            });

                    if (visible) {
                        return locator;
                    }
                }
            }
            return null;
        });
    }
}