package requests.ping;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetPingRequest {

    @Step("Retorna api online")
    public Response pingReturnApi(){
        return RestAssured.given()
                  .header("Content-Type","application/json")
                  .when()
                  .get("ping");
    }
}
