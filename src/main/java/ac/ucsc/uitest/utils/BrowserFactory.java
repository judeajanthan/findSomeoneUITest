package ac.ucsc.uitest.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class BrowserFactory {

    private static final ThreadLocal<WebDriver> DRIVER =
            new ThreadLocal<>();

    private BrowserFactory() {
        // Utility class; no instances required
    }

    public static WebDriver createDriver() {
        if (DRIVER.get() != null) {
            throw new IllegalStateException(
                    "A WebDriver already exists for this thread."
            );
        }

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            DRIVER.set(driver);
            return driver;
        } catch (RuntimeException e) {
            driver.quit();
            throw e;
        }
    }

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();

        if (driver == null) {
            throw new IllegalStateException(
                    "No WebDriver exists for this thread. "
                            + "Call createDriver() first."
            );
        }

        return driver;
    }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();

        try {
            if (driver != null) {
                driver.quit();
            }
        } finally {
            DRIVER.remove();
        }
    }
}