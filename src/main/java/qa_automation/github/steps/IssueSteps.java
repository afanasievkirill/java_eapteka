package qa_automation.github.steps;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import qa_automation.github.model.Issue;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.equalTo;

public class IssueSteps {

    Issue issue = new Issue();

    @Step("Ищем репозиторий")
    public void findRepository(String REPOSITORY){
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
    }

    @Step("Открываем репозиторий")
    public void openRepository(String REPOSITORY){
        $(By.linkText(REPOSITORY)).click();
    }

    @Step("Открываем список задач")
    public void openIssueList(){
        $x("//*[@data-content='Issues']").shouldBe(visible).click();
    }

    @Step("Открываем форму создания задачи")
    public void createIssue(){
        $x("//*[@class='btn btn-primary']/span").shouldBe(visible).click();
    }

    @Step("Заполняем заголовок и тело задачи")
    public void fillForm(String issueTitle, String issueBody){
        $(byId("issue_title")).shouldBe(visible).setValue(issueTitle);
        $(byId("issue_body")).shouldBe(visible).setValue(issueBody);
    }

    @Step("Выбираем ответственного (Переписать локатор)")
        public void setUser(){
        $(byId("assignees-select-menu")).shouldBe(visible).click();
        // Не стабильный локатор
        $(".js-username").shouldBe(visible).click();
        $(byId("assignees-select-menu")).shouldBe(visible).click();
    }

    @Step("Выбираем тип задачи")
    public void setType(String issueType){
        $(byText("Labels")).shouldBe(visible).click();
        $(byText(issueType)).shouldBe(visible).click();
        $(byText("Labels")).shouldBe(visible).click();
    }

    @Step("Сохраняем задачу")
    public void saveIssue(){
        $(byText("Submit new issue")).shouldBe(visible).click();
    }

    @Step("Получаем номер задачи")
    public int getIssueNumber(){
        return Integer
                .parseInt($(".js-issue-title").sibling(0).getText().replace("#", ""));
    }

    @Step("Проверяем тело ответа по Задаче")
    public void assertRequest(Issue issue, int issueNumber, String issueTitle, String issueBody){
        assertThat(issue.getNumber(), comparesEqualTo(issueNumber));
        assertThat(issue.getTitle(), equalTo(issueTitle));
        assertThat(issue.getBody(), equalTo(issueBody));
    }
}
