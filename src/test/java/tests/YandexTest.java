package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YandexTest {

    @Test
    void selenideSearcTest(){
        open("https://yandex.ru/");

        // Ввести Selenide в поиск
        $(byId("text")).setValue("Selenide").pressEnter();

        // Проверить, что Selenide появился в результатах поиска
        $(byXpath("//*[@class='link link_theme_outer path__item i-bem link_js_inited']//b"))
                .shouldHave(text("ru.selenide.org"));
    }
}
