package tests.eapteka;

import io.qameta.allure.Issue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Issue("WEB-15283")
    @DisplayName("Логин на сайте по почте")
    @ParameterizedTest
    @CsvSource({"coxoyis908@in4mail.net,password"})
    public void loginTest(String login, String password){
        loginPage.openLoginForm();
        loginPage.setLogin(login);
        loginPage.setPassword(password);
        loginPage.loginCheck();
        loginPage.logout();
    }

    @Issue("WEB-15283")
    @DisplayName("Логин на сайте по телефону")
    @ParameterizedTest
    @CsvSource({"79153913430,password"})
        public void phoneLoginTest(String login, String password){
        loginPage.openLoginForm();
        loginPage.setLogin(login);
        loginPage.setPassword(password);
        loginPage.loginCheck();
        loginPage.logout();
    }


}
