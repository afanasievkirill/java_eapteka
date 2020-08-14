package qa_automation.github.steps;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import qa_automation.github.model.Issue;

import static io.restassured.RestAssured.given;

public class RestAssuredSteps {

    @Step("Создаем задачу с заданным названием")
    public Issue createIssue(String title) {
        final Issue toCreate = new Issue();
        toCreate.setTitle(title);
        // @formatter:off
        return given()
                .filter(new AllureRestAssured())
                .header("Authorization", "token 728126394059a3991c9e6e3b8e83121401f35f6e")
                .baseUri("https://api.github.com")
                .body(toCreate)
                .when()
                .post("/repos/eroshenkoam/allure-example/issues")
                .then()
                .statusCode(201)
                .extract()
                .as(Issue.class);
        // @formatter:on
    }

    @Step("Получаем информацию о задаче по номеру")
    public Issue getIssue(String repo, int number, String TOKEN){
        return  given()
                .filter(new AllureRestAssured())
                .header("Authorization", "token " + TOKEN )
                .baseUri("https://api.github.com")
                .when()
                .get("repos/"+ repo + "/issues/" + number)
                .then()
                .extract()
                .as(Issue.class);
    }
}
