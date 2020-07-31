package tests;

import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class EaptekaBaseTest {

    @BeforeAll
    public static void setUp(){
        open("https://www.eapteka.ru/");
        $x("//*[@class='header__tower-skip header__skip-start btn btn-success btn-sm']").click();
    }
}
