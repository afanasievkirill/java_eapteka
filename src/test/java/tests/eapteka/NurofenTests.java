package tests.eapteka;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class NurofenTests extends BaseTest {

    @Test
    void findNurofen(){
        entrance.shouldHave(text("Вход")).click();
        setLogin.setValue("coxoyis908@in4mail.net");
        setPassword.setValue("password").pressEnter();
        entrance.shouldHave(text("Личный кабинет"));

        String name = "Афобазол";
        searchBar.setValue(name);
        searchSubbmit.click();
        $x(".//strong[text()="+name+"]");
    }
}
