package qa_automation.github.steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginSteps {

    @Step
    public void login(String LOGIN, String PASSWORD){
        $x("//*[@class='HeaderMenu-link no-underline mr-3']").shouldBe(visible).click();
        $(byName("login")).shouldBe(visible).setValue(LOGIN);
        $(byName("password")).shouldBe(visible).setValue(PASSWORD).pressEnter();
    }
}
