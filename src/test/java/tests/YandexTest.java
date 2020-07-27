package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YandexTest {

    @Test
    void selenideSearchTest(){
        open("https://yandex.ru/");

        // Ввести Selenide в поиск
        $(byId("text")).setValue("Selenide").pressEnter();

        // Проверить, что Selenide появился в результатах поиска
        $(byXpath("//*[@class='organic__subtitle typo typo_type_greenurl']//b"))
                .shouldHave(text("ru.selenide.org"));
    }
}
