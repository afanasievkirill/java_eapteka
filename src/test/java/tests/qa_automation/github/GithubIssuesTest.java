package tests.qa_automation.github;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import qa_automation.github.ApiSteps;
import qa_automation.github.BasicSteps;
import qa_automation.github.Issue;

@Feature("Работа с задачами")
public class GithubIssuesTest {

    private final static String REPOSITORY = "eroshenkoam/allure-example";

    private ApiSteps apiSteps = new ApiSteps();
    private BasicSteps basicSteps = new BasicSteps();

    @Before
    public void initSelenideListener() {
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
    }

    @Before
    public void initGithubClient() {
    }

    @Test
    @Story("Проверка наличия задач")
    @DisplayName("Проверка наличия Issues в проекте GitHub")
    public void testIssueExistsWithoutStepsTest() throws Exception {
        final Issue issue = apiSteps.createIssue(
                "eroshenkoam",
                "allure-example",
                "hello from qa.guru",
                "ping-pong"
        );
        basicSteps.openMainPage("eroshenkoam");
        basicSteps.searchForRepository(REPOSITORY);
        basicSteps.openRepositoryIssues();
        basicSteps.shouldSeeIssueWithId(issue.getNumber());
    }
}
