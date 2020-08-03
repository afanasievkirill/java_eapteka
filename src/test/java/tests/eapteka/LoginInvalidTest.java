package tests.eapteka;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;

public class LoginInvalidTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "Noname", " ", "!@#$%^&*()"})
    public void wrongLoginTest(String invalidLogin){
        entrance.shouldHave(text("Вход")).click();
        setLogin.setValue(invalidLogin);
        setPassword.setValue("password").pressEnter();
        loginError.shouldHave(text("Введённое значение неверно"));
        popupClose.click();
    }
}
