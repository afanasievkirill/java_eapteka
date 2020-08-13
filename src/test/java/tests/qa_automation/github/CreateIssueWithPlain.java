package tests.qa_automation.github;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Feature("Создание задачи")
@Story("Использование Лямбда функций")
@Owner("afanasievkirill")
public class CreateIssueWithPlain extends BaseTest {

    private static final String name = "afanasievkirill/java_eapteka";

    @ParameterizedTest
    @CsvFileSource(resources = "/githubProperties.csv", numLinesToSkip = 1)
    public void createIssueWithPlain(String login, String password){
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Залогиниваеся на сайте", () -> {
            $x("//*[@class='HeaderMenu-link no-underline mr-3']").shouldBe(visible).click();
            $(byName("login")).shouldBe(visible).setValue(login);
            $(byName("password")).shouldBe(visible).setValue(password).pressEnter();
        });
        step("Ищем репозиторий", () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(name);
            $(".header-search-input").submit();
        });
        step("Переходим в найденый репозиторий", () -> {
            $(By.linkText(name)).click();
        });
        step("Переходим в список задач", () -> {
            $x("//*[@data-content='Issues']").shouldBe(visible).click();
        });
        step("Открываем форму создания Задачи", () -> {
            $x("//*[@class='btn btn-primary']/span").shouldBe(visible).click();
        });
        step("Заполняем Заголовок и Описание", () -> {
            $(byId("issue_title")).shouldBe(visible).setValue("First issue");
            $(byId("issue_body")).shouldBe(visible).setValue("First body");
        });
        step("Выбираем ответсвенного", () -> {
            $(byId("assignees-select-menu")).shouldBe(visible).click();
            // Не стабильный локатор
            $(".js-username").shouldBe(visible).click();
            $(byId("assignees-select-menu")).shouldBe(visible).click();
        });
        step("Выбираем тип задачи", () -> {
            $(byText("Labels")).shouldBe(visible).click();
            $(byText("bug")).shouldBe(visible).click();
            $(byText("Labels")).shouldBe(visible).click();
        });
        step("Сохраняем задачу", () -> {
            $(byText("Submit new issue")).shouldBe(visible).click();
        });
        step("Переходим в задачу по номеру", () -> {
            int issueNumber = Integer
                    .parseInt($(".js-issue-title").sibling(0).getText().replace("#", ""));
            open("https://github.com/afanasievkirill/java_eapteka/issues/" + issueNumber);
        });
        step("Проверяем исполнителя и тип задачи", () -> {
            $(".author text-bold link-gray").shouldHave(text("afanasievkirill"));
            $(".css-truncate-target").shouldHave(text("bug"));
        });

    }
}
