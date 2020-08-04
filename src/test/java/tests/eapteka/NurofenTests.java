package tests.eapteka;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NurofenTests extends BaseTest {



    @Test
    void findNElement(){
        //Поиск
        String name = "Афобазол";
        searchBar.setValue(name);
        searchSubbmit.click();
        $x(".//strong[text()="+name+"]");
        //Добавление первого элемента в корзину (Без проверки)
        $x(".//*[@class='cc-item--title']").shouldHave(text(name));
        $x(".//*[@class='cc-item--title']").click();
    }


    @Test
    public void findSet(){
        String name = "Нурофен";
        int quantity = 19;
        String result = "Найдено " + quantity + " результатов";
        searchBar.setValue(name);
        searchSubbmit.pressEnter();
        String findResult = $x(".//*[@class='text-muted d-block d-sm-inline']").getText();
        assertEquals(result, findResult);
        $$x(".//*[@class='d-flex align-items-start align-items-lg-center cc-item']").shouldHaveSize(quantity);

    }




}
