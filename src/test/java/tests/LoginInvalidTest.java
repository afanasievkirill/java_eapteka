package tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginInvalidTest extends EaptekaBaseTest{

    @ParameterizedTest
    @ValueSource(strings = {"1", "Noname", " ", "!@#$%^&*()"})
    public void wrongLoginTest(String invalidLogin){
        $x(ENTRANCE).shouldHave(text("Вход")).click();
        $(By.name("LOGIN")).setValue(invalidLogin);
        $(By.name("PASSWORD")).setValue("password").pressEnter();
        $x(LOGIN_ERROR).shouldHave(text("Введённое значение неверно"));
        $x(POPUP_CLOSE).click();
    }
}
