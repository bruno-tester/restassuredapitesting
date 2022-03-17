package requests.auth;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import payloads.AuthPayloads;

public class PostAuthRequest {
    AuthPayloads authPayloads = new AuthPayloads();

    @Step("Retorna o token")
    public Response tokenReturn(){

        return RestAssured.given()
                .header("Content-Type","application/json")
                .when()
                .body(authPayloads.jsonAuthLogin().toString())
                .post("auth");
    }

    @Step("Busca o token")
    public String getToken(){

        return "token="+this.tokenReturn()
                .then()
                .statusCode(200)
                .extract()
                .path("token");
    }
}
