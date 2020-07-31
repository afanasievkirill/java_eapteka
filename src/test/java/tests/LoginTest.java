package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginTest extends EaptekaBaseTest{

    private String ENTRANCE = "//*[@class='htop__links right']/a[2]";

    @Test
    public void loginTest(){

        $x(ENTRANCE)
                .shouldHave(text("Вход")).click();
        $(By.name("LOGIN")).setValue("coxoyis908@in4mail.net");
        $(By.name("PASSWORD")).setValue("password").pressEnter();
        $x(ENTRANCE)
                .shouldHave(text("Личный кабинет"));
    }
}
