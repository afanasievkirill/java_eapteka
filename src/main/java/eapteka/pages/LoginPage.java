package eapteka.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.parameter;

public class LoginPage {

    private static final  SelenideElement
            entrance = $x("//*[@class='htop__links right']/a[2]"),
            logout = $x("//*[@class='htop__links right']/a[3]"),
            setLogin = $(byName("LOGIN")),
            setPassword = $(byName("PASSWORD")),
            loginError = $x("//*[@class='help-block form-error']"),
            loginFormClose = $x("//*[@class='popups__xclose']");

    @Step("Логин на сайте")
    public LoginPage logInToTheSite(String login, String password){
        parameter("Логин", login);
        parameter("Пароль", password);
        openLoginForm();
        setLogin(login);
        setPassword(password);
        loginCheck();
        return this;
    }

    @Step("Есть ссылка на Личный кабинет")
    public LoginPage loginCheck(){
        entrance.shouldHave(text("Личный кабинет")).shouldBe(visible);
        return this;
    }

    @Step("Открыть форму логина")
    public LoginPage openLoginForm (){
        entrance.shouldHave(text("Вход")).shouldBe(visible).click();
        return this;
    }

    @Step("Выход из аккаунта")
    public LoginPage clickLogout(){
        logout.shouldHave(text("Выход")).shouldBe(visible).click();
        return this;
    }

    @Step("Ввод значения {login} в поле ввода Логин")
    public LoginPage setLogin(String login){
        parameter("Логин", login);
        setLogin.shouldBe(visible).setValue(login);
        return this;
    }

    @Step("Ввод значения {password} в поле ввода Пароль")
    public LoginPage setPassword (String password){
        parameter("Пароль", password);
        setPassword.shouldBe(visible).setValue(password).pressEnter();
        return this;
    }

    @Step("Проверка исключение для невалидного Логина")
    public LoginPage loginError (){
        loginError.shouldHave(text("Введённое значение неверно")).shouldBe(visible);
        return this;
    }

    @Step("Выход из формы Логина")
    public LoginPage closeLoginForm (){
        loginFormClose.click();
        entrance.scrollTo().shouldHave(text("Вход")).shouldBe(visible);
        return this;
    }
}
