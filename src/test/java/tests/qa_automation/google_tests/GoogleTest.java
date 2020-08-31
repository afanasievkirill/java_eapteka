package tests.qa_automation.google_tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Story("Тестирование поиска в Гугле")
class GoogleTest extends BaseTest {

    @Tag("GoogleTest")
    @DisplayName("Проверяем выдачу  по запросу Селенид")
    @Test
    void selenideSearchTest() {
        open("https://google.com");
        $(byName("q")).shouldBe(visible).setValue("Selenide").pressEnter();
      //  $(".html").shouldBe(visible).shouldHave(text("ru.selenide.org"));
    }
}
