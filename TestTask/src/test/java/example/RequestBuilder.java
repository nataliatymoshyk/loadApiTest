package example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestBuilder {

    public Response buildGetPhoneRequest(String phoneNumber) {

        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .queryParam("number", phoneNumber)
                .queryParam("access_key","7379b39e5f49a8efc3920586554589bf")
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .response();
    }


}