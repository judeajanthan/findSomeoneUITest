package ac.ucsc.uitest.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

    private static BrowserFactory browserFactory;
    private WebDriver driver; // Store the driver here

    private BrowserFactory() {
    }

    public static BrowserFactory getBROWSER_FACTORY() {
        if (browserFactory == null) {
            browserFactory = new BrowserFactory();
        }
        return browserFactory;
    }

    public WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
}
