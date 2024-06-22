import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PostmanEchoTests {

    @BeforeClass
    public void setupBaseUri() {
        // Установка базового URI
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void GetRequest() {
        // Тестирование GET-запроса, проверка тела ответа, сравнение значений полей и кода ответа
        Response response = given()
                .log().all()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .log().all()
                .statusCode(200)
                .body("args", hasEntry("foo1", "bar1"))
                .body("args", hasEntry("foo2", "bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", nullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"))
                .extract().response();
    }

    @Test
    public void PostRawText() {
        //тестирование Post Raw Text запрос проверка тела ответа, сравнить значения всех полей и кода ответа
        Response response = given()
                .log().all()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", nullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", nullValue())
                .extract().response();
    }

    @Test
    public void PostFormData() {
        //тестирование Post From Date запрос проверка тела ответа, сравнить значения всех полей и кода ответа
        Response response = given()
                .log().all()
                .contentType("application/json")
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("form.foo1", nullValue())
                .body("form.foo2", nullValue())
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connect-lenght", nullValue())
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", nullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", nullValue())
                .body("json.foo1", nullValue())
                .body("json.foo2", nullValue())
                .extract().response();
    }

    @Test
    public void PutRequest() {
        //тестирование Put запрос проверка тела ответа сравнить значения всех полей и кода ответа
        Response response = given()
                .log().all()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("/put")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connect-lenght", nullValue())
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", nullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", nullValue())
                .extract().response();
    }

    @Test
    public void PatchRequest() {
        //тестирование Patch запрос проверка тела ответа, сравнить значения всех полей и кода ответа
        Response response = given()
                .log().all()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.connect-lenght", nullValue())
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", nullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", nullValue())
                .extract().response();
    }

    @Test
    public void DeleteRequest() {
        //Тестирование Delete запрос проверка тела ответа, сравнить значения всех полей и кода ответа
        Response response = given()
                .log().all()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("/delete")
                .then()
                .log().all()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", notNullValue())
                .body("headers.content-length", nullValue())
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", notNullValue())
                .body("headers.accept", equalTo("*/*"))
                .body("headers.postman-token", nullValue())
                .body("headers.accept-encoding", equalTo("gzip,deflate"))
                .body("headers.cookie", nullValue())
                .extract().response();
    }
}