package ac.ucsc.uitest.tests.chatdb;

import ac.ucsc.uitest.tests.BaseTest;
import org.testng.annotations.BeforeClass;

/**
 * @author aerok
 * @code @created 03/04/2026
 */
public class ChatBaseTest extends BaseTest {
    @BeforeClass
    public void setFilePath() {
        super.filePath = "src/main/resources/assertiondata/chat_data.json";
    }
}
