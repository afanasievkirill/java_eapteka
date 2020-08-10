package tests.eapteka;

import io.qameta.allure.Issue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import eapteka.pages.LoginPage;

public class LoginInvalidTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Issue("WEB-15283")
    @DisplayName("Проверяю ввод невалидных данных в поле Логин")
    @Tag("LoginTest")
    @ParameterizedTest
    @ValueSource(strings = {"1", "Noname", " ", "!@#$%^&*()"})
    public void wrongLoginTest(String login){
        loginPage.openLoginForm();
        loginPage.setLogin(login);
        loginPage.setPassword("password");
        loginPage.loginError();
        loginPage.closeLoginForm();
    }
}
