package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SearchTest extends EaptekaBaseTest {

    @Test
    public void searchTest(){
        String name = "Афобазол";
        searchBar.setValue(name);
        searchSubbmit.click();
        $x(".//strong[text()="+name+"]");
    }
}
