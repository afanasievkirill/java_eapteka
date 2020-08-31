package tests.qa_automation.github;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import qa_automation.github.model.Issue;

public class BaseTest {

    protected static Issue issue = new Issue();
    protected static final String issueTitle = "First issue";
    protected static final String issueBody = "First body";
    protected static final String issueType = "bug";

    @BeforeAll
    public static void beforeAll(){
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true).screenshots(true));
    }

}
