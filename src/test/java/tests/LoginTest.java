package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginTest extends EaptekaBaseTest{



    @Test
    public void loginTest(){
        $x(ENTRANCE).shouldHave(text("Вход")).click();
        $(By.name("LOGIN")).setValue("coxoyis908@in4mail.net");
        $(By.name("PASSWORD")).setValue("password").pressEnter();
        $x(ENTRANCE).shouldHave(text("Личный кабинет"));
    }

    @ParameterizedTest
    @CsvSource({"79153913430,password"})
        public void phoneLoginTest(String login, String password){
        $x(ENTRANCE).shouldHave(text("Вход")).click();
        $(By.name("LOGIN")).setValue(login);
        $(By.name("PASSWORD")).setValue(password).pressEnter();
        $x(ENTRANCE).shouldHave(text("Личный кабинет"));
    }


}
