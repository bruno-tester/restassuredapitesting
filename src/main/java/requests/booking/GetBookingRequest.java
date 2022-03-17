package requests.booking;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetBookingRequest {

    @Step("Retorna os Ids da Listagem de Reservas ")
    public Response bookingReturnIds(){
        return RestAssured.given()
                   .when()
                   .get("booking");
    }
}
