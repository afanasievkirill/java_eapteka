package tests.eapteka;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.text;

public class LoginInvalidTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

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
