package ac.ucsc.uitest.tests;

import ac.ucsc.uitest.models.BaseDataModel;
import ac.ucsc.uitest.models.SearchData;
import ac.ucsc.uitest.pages.BasePage;
import ac.ucsc.uitest.utils.BaseReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import tools.jackson.core.type.TypeReference;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author aerok
 * {@code @created} 15/03/2026
 */
public class BaseTest extends BaseReader {

    protected String filePath;

    protected WebDriver driver;
    protected BasePage basePage;

    @BeforeMethod
    public void setupBrowser() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        basePage = PageFactory.initElements(driver, BasePage.class);
    }

    @DataProvider(name = "commonDataProvider")
    public Iterator<Object[]> commonDataProvider(Method method) {
        System.out.println("FilePath: " + filePath);

        // 1. Extract the TC ID from the @Test description
        Test testAnnotation = method.getAnnotation(Test.class);
        String testCaseId = testAnnotation.description();

        // 2. Load the List of wrappers
        List<BaseDataModel<SearchData>> allData = loadJsonData(filePath,
                new TypeReference<List<BaseDataModel<SearchData>>>() {
                });

        return allData.stream()
                // 3. Find the specific Test Case ID
                .filter(node -> node.getTestId().equalsIgnoreCase(testCaseId))
                .findFirst()
                // 4. Map the List<SearchData> to List<Object[]>
                .map(node -> node.getTestData().stream()
                        .map(data -> new Object[]{data})
                        .toList())
                // 5. Convert to Iterator (or return empty if not found)
                .orElse(Collections.emptyList())
                .iterator();
    }
}
