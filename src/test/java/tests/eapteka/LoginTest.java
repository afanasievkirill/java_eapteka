package tests.eapteka;

import eapteka.pages.LoginPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Feature("Для Бизнеса важно, что Пользователь может залогинится")
public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Issue("WEB-15283")
    @DisplayName("Логин на сайте по почте")
    @Tag("LoginTest")
    @ParameterizedTest
    @CsvSource({"coxoyis908@in4mail.net,password"})
    public void loginTest(String login, String password){
        loginPage.openLoginForm();
        loginPage.setLogin(login);
        loginPage.setPassword(password);
        loginPage.loginCheck();
        loginPage.clickLogout();
    }

    @Issue("WEB-15283")
    @DisplayName("Логин на сайте по телефону")
    @Tag("LoginTest")
    @ParameterizedTest
    @CsvSource({"79153913430,password"})
        public void phoneLoginTest(String login, String password){
        loginPage.openLoginForm();
        loginPage.setLogin(login);
        loginPage.setPassword(password);
        loginPage.loginCheck();
        loginPage.clickLogout();
    }


}
