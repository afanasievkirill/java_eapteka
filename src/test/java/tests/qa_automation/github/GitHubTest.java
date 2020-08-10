package tests.qa_automation.github;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GitHubTest {

    @Test
    @Story("Проверка наличия проекта")
    @DisplayName("Проверка наличия созданного проекта GitHub")
    public void testCreatedProjectExists() {
        assertEquals(true, true);
    }

    @Test
    @Story("Проверка наличия проекта")
    @DisplayName("Проверка наличия дефолтного проекта GitHub")
    public void testDefaultProjectExists() {
        assertEquals(true, false);
    }
}
