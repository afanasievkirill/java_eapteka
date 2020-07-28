package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class YandexTest {

    @Test
    void selenideSearchTestSX(){
        open("https://yandex.ru/");
        $(byId("text")).setValue("Selenide").pressEnter();
        $x("//*[@class='organic__subtitle typo typo_type_greenurl']//b")
                .shouldHave(text("ru.selenide.org"));
    }

    @Test
    void selenideSearchTest(){
        open("https://yandex.ru/");
        $(byId("text")).setValue("Selenide").pressEnter();
        $(byXpath("//*[@class='organic__subtitle typo typo_type_greenurl']//b"))
                .shouldHave(text("ru.selenide.org"));
    }

    @Test
    void selenideSearchTestCSS(){
        open("https://yandex.ru/");
        $(byId("text")).setValue("Selenide").pressEnter();
        $(".organic__subtitle.typo.typo_type_greenurl b")
                .shouldHave(text("ru.selenide.org"));
    }
}
