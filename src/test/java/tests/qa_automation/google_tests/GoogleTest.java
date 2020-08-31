package tests.qa_automation.google_tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class GoogleTest extends BaseTest{

    @Tag("GoogleTest")
    @Test
    void selenideSearchTest() {


        Configuration.headless = true;
        open("https://google.com");
        $(byName("q")).setValue("Selenide").pressEnter();
        $("html").shouldHave(text("ru.selenide.org"));
    }
}
