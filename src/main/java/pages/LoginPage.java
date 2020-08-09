package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private static final  SelenideElement
            entrance = $x("//*[@class='htop__links right']/a[2]"),
            logout = $x("//*[@class='htop__links right']/a[3]"),
            setLogin = $(byName("LOGIN")),
            setPassword = $(byName("PASSWORD")),
            loginError = $x("//*[@class='help-block form-error']"),
            loginFormClose = $x("//*[@class='popups__xclose']");

    @Step("Залогиниваюсь на сатйе")
    public LoginPage logInToTheSite(String login, String password){
        openLoginForm();
        setLogin(login);
        setPassword(password);
        return this;
    }

    @Step
    public LoginPage loginCheck(){
        entrance.shouldHave(text("Личный кабинет")).shouldBe(visible);
        return this;
    }

    @Step("Открываю форму логине")
    public LoginPage openLoginForm (){
        entrance.shouldHave(text("Вход")).shouldBe(visible).click();
        return this;
    }

    @Step("Разлогиниваюсь")
    public LoginPage logout (){
        logout.shouldHave(text("Выход")).shouldBe(visible).click();
        return this;
    }

    @Step("Ввожу значение {login} в поле ввода логина")
    public LoginPage setLogin(String login){
        setLogin.shouldBe(visible).setValue(login);
        return this;
    }

    @Step("Ввожу значение {password} в поле ввода пароля")
    public LoginPage setPassword (String password){
        setPassword.shouldBe(visible).setValue(password).pressEnter();
        return this;
    }

    @Step("Проверяю исключение для невалидного Логина")
    public LoginPage loginError (){
        loginError.shouldHave(text("Введённое значение неверно")).shouldBe(visible);
        return this;
    }

    @Step("Закрываю форму логина")
    public LoginPage closeLoginForm (){
        loginFormClose.click();
        entrance.scrollTo().shouldHave(text("Вход")).shouldBe(visible);
        return this;
    }
}
