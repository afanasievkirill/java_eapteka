package tests.eapteka;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.text;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test
    public void loginTest(){
        loginPage.openLoginForm();
        loginPage.setLogin("coxoyis908@in4mail.net");
        loginPage.setPassword("password");
        loginPage.loginCheck();
        loginPage.logout();
    }

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
