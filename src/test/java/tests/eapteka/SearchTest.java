package tests.eapteka;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Issue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import eapteka.pages.SearchPage;

import static com.codeborne.selenide.Selenide.$x;

public class SearchTest extends BaseTest {

    SearchPage searchPage = new SearchPage();

    @Issue("WEB-15371")
    @DisplayName("Проверяю работу поиска")
    @Test
    public void searchTest(){
        String name = "Афобазол";
        searchPage.setProductName(name);
        searchSubbmit.click();
        $x(".//strong[text()="+name+"]").shouldHave(Condition.visible);
    }
}
