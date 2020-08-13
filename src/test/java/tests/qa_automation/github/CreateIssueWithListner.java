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
import static com.codeborne.selenide.Selenide.*;

@Feature("Создание задачи")
@Story("Использование листнеров")
@Owner("afanasievkirill")
public class CreateIssueWithListner extends BaseTest{

    private static final String name = "afanasievkirill/java_eapteka";

    @ParameterizedTest
    @CsvFileSource(resources = "/githubProperties.csv", numLinesToSkip = 1)
    public void createIssueWithListner(String login, String password) {
        open("https://github.com/");
        $x("//*[@class='HeaderMenu-link no-underline mr-3']").shouldBe(visible).click();
        $(byName("login")).shouldBe(visible).setValue(login);
        $(byName("password")).shouldBe(visible).setValue(password).pressEnter();
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(name);
        $(".header-search-input").submit();
        $(By.linkText(name)).click();
        $x("//*[@data-content='Issues']").shouldBe(visible).click();
        $x("//*[@class='btn btn-primary']/span").shouldBe(visible).click();
        $(byId("issue_title")).shouldBe(visible).setValue("First issue");
        $(byId("issue_body")).shouldBe(visible).setValue("First body");
        $(byId("assignees-select-menu")).shouldBe(visible).click();
        // Не стабильный локатор
        $(".js-username").shouldBe(visible).click();
        $(byId("assignees-select-menu")).shouldBe(visible).click();
        $(byText("Labels")).shouldBe(visible).click();
        $(byText("bug")).shouldBe(visible).click();
        $(byText("Labels")).shouldBe(visible).click();
        $(byText("Submit new issue")).shouldBe(visible).click();
        int issueNumber = Integer
                .parseInt($(".js-issue-title").sibling(0).getText().replace("#", ""));
        open("https://github.com/afanasievkirill/java_eapteka/issues/" + issueNumber);
        $x(".author text-bold link-gray").shouldHave(text("afanasievkirill"));
        $(".css-truncate-target").shouldHave(text("bug"));
    }
}
