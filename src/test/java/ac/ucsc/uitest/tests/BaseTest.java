package ac.ucsc.uitest.tests;

import ac.ucsc.uitest.models.BaseDataModel;
import ac.ucsc.uitest.models.SearchData;
import ac.ucsc.uitest.pages.BasePage;
import ac.ucsc.uitest.utils.BaseReader;
import ac.ucsc.uitest.utils.BrowserFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import tools.jackson.core.type.TypeReference;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BaseTest extends BaseReader {

    protected String filePath;
    protected WebDriver driver;
    protected BasePage basePage;

    @BeforeMethod
    public void setupBrowser() {
        driver = BrowserFactory.createDriver();
        basePage = PageFactory.initElements(driver, BasePage.class);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        try {
            BrowserFactory.quitDriver();
        } finally {
            driver = null;
            basePage = null;
        }
    }

    @DataProvider(name = "commonDataProvider")
    public Iterator<Object[]> commonDataProvider(Method method) {
        System.out.println("FilePath: " + filePath);

        // Extract the test case ID from the @Test description.
        Test testAnnotation = method.getAnnotation(Test.class);
        String testCaseId = testAnnotation.description();

        // Load the test data from JSON.
        List<BaseDataModel<SearchData>> allData = loadJsonData(
                filePath,
                new TypeReference<List<BaseDataModel<SearchData>>>() {}
        );

        // Find the matching test case and convert its data to TestNG arguments.
        return allData.stream()
                .filter(node ->
                        node.getTestId().equalsIgnoreCase(testCaseId))
                .findFirst()
                .map(node -> node.getTestData().stream()
                        .map(data -> new Object[]{data})
                        .toList())
                .orElse(Collections.emptyList())
                .iterator();
    }
}