package tests.eapteka;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;

public class LoginTest extends BaseTest {



    @Test
    public void loginTest(){
        entrance.shouldHave(text("Вход")).click();
        setLogin.setValue("coxoyis908@in4mail.net");
        setPassword.setValue("password").pressEnter();
        entrance.shouldHave(text("Личный кабинет"));
        logout.shouldHave(text("Выход")).click();
    }

    @ParameterizedTest
    @CsvSource({"79153913430,password"})
        public void phoneLoginTest(String login, String password){
        entrance.shouldHave(text("Вход")).click();
        setLogin.setValue(login);
        setPassword.setValue(password).pressEnter();
        entrance.shouldHave(text("Личный кабинет"));
        logout.shouldHave(text("Выход")).click();
    }


}
