package tests.qa_automation.github;


import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import qa_automation.github.model.Issue;
import qa_automation.github.steps.BasicSteps;
import qa_automation.github.steps.IssueSteps;
import qa_automation.github.steps.LoginSteps;
import qa_automation.github.steps.RestAssuredSteps;

@Feature("Создание задачи")
@DisplayName("Создание задачи и проверка через АПИ")
@Story("Использование степов")
@Owner("afanasievkirill")
public class CreateIssueWithSteps extends BaseTest{

    public BasicSteps basicSteps = new BasicSteps();
    public LoginSteps loginSteps = new LoginSteps();
    public IssueSteps issueSteps = new IssueSteps();
    public RestAssuredSteps apiSteps = new RestAssuredSteps();
    public Issue issue = new Issue();
    private static int issueNumber;

    @DisplayName("Создание задачи и проверка через АПИ с использованием Степов")
    @ParameterizedTest
    @CsvFileSource(resources = "/githubProperties.csv", numLinesToSkip = 1)
    public void createIssueWithSteps(String LOGIN, String PASSWORD, String REPOSITORY, String TOKEN){
        basicSteps.openMainPage();
        loginSteps.login(LOGIN, PASSWORD);
        issueSteps.findRepository(REPOSITORY);
        issueSteps.openRepository(REPOSITORY);
        issueSteps.openIssueList();
        issueSteps.createIssue();
        issueSteps.fillForm(issueTitle, issueBody);
        issueSteps.setUser();
        issueSteps.setType(issueType);
        issueSteps.saveIssue();
        issueNumber = issueSteps.getIssueNumber();
        issue = apiSteps.getIssue(REPOSITORY, issueNumber);
        issueSteps.assertRequest(issue,issueNumber,issueTitle, issueBody);
    }
}
