package tests.eapteka;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class NurofenTests extends BaseTest {

    @Test
    void findNurofen(){
        //Логин
        entrance.shouldHave(text("Вход")).click();
        setLogin.setValue("coxoyis908@in4mail.net");
        setPassword.setValue("password").pressEnter();
        entrance.shouldHave(text("Личный кабинет"));
        //Поиск
        String name = "Афобазол";
        searchBar.setValue(name);
        searchSubbmit.click();
        $x(".//strong[text()="+name+"]");
        //Добавление первого элемента в корзину (Без проверки)
        $x(".//*[@class='cc-item--title']").shouldHave(text(name));
        $x(".//*[@class='cc-item--title']").click();
        //Выход
        logout.shouldHave(text("Выход")).click();
    }
}
