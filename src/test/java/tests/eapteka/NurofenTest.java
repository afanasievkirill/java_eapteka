package tests.eapteka;

import eapteka.pages.SearchPage;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class NurofenTest extends BaseTest {

    SearchPage searchPage = new SearchPage();

    @Issue("WEB-15371")
    @DisplayName("Проверяю работу поиска")
    @Test
     public void findNElementTest(){
        String name = "Афобазол";
        searchPage.setProductName(name);
        searchPage.pressSubbmitButton();
        $x(".//strong[text()="+name+"]");
        $x(".//*[@class='cc-item--title']").shouldHave(text(name));
        $x(".//*[@class='cc-item--title']").click();
    }

    @Issue("WEB-15371")
    @DisplayName("Проверяю наличие {quantity} элементов в списке при поиске по имени {name}")
    @Test
    public void findSetTest(){
        String name = "Нурофен";
        int quantity = 19;
        searchPage.setProductName(name);
        searchPage.pressEnter();
        searchPage.checkHeaderElementsList(quantity);
        searchPage.checkList(quantity);
    }

}
