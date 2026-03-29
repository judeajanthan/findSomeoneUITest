package ac.ucsc.uitest.tests.home;

import ac.ucsc.uitest.tests.BaseTest;
import org.testng.annotations.BeforeClass;

/**
 * @author aerok
 * @code @created 28/03/2026
 */
public class HomeBaseTest extends BaseTest {
    @BeforeClass
    public void setFilePath() {
        super.filePath = "src/main/resources/assertiondata/home_data.json";
    }
}
