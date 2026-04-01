package ac.ucsc.uitest.tests.find;

import ac.ucsc.uitest.tests.BaseTest;
import org.testng.annotations.BeforeClass;

public class FindBaseTest extends BaseTest {
    @BeforeClass
    public void setFilePath() {
        super.filePath = "src/main/resources/assertiondata/find_data.json";
    }
}
