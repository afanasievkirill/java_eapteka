package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import io.qameta.allure.Step;

public class LoginPage {

    private final SelenideElement
            entrance = $x("//*[@class='htop__links right']/a[2]"),
            logout = $x("//*[@class='htop__links right']/a[3]"),
            setLogin = $(byName("LOGIN")),
            setPassword = $(byName("PASSWORD")),
            loginError = $x("//*[@class='help-block form-error']"),
            loginFormClose = $x("//*[@class='popups__xclose']");

    @Step("Login")
    public LoginPage logInToTheSite(String login, String password){
        openLoginForm();
        setLogin(login);
        setPassword(password);
        return this;
    }

    @Step
    public LoginPage loginCheck(){
        entrance.shouldHave(text("Личный кабинет"));
        return this;
    }

    @Step("Open login form")
    public LoginPage openLoginForm (){
        entrance.shouldHave(text("Вход")).click();
        return this;
    }

    @Step("Loggin out")
    public LoginPage logout (){
        logout.shouldHave(text("Выход")).click();
        return this;
    }

    @Step("Set value {login} to Login input")
    public LoginPage setLogin(String login){
        setLogin.setValue(login);
        return this;
    }

    @Step("Set value {password} to Password input")
    public LoginPage setPassword (String password){
        setPassword.setValue(password).pressEnter();
        return this;
    }



    @Step("Check login input error")
    public LoginPage loginError (){
        loginError.shouldHave(text("Введённое значение неверно"));
        return this;
    }

    @Step("Close login form")
    public LoginPage closeLoginForm (){
        loginFormClose.click();
        entrance.scrollTo().shouldHave(text("Вход"));
        return this;
    }
}
