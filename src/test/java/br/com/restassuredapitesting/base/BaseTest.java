package br.com.restassuredapitesting.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.FilterableRequestSpecification;
import org.junit.After;
import org.junit.BeforeClass;
import utils.EnvUtils;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.requestSpecification;
import static utils.Constants.APP_BASE_URL_HLG;

public class BaseTest {

    @BeforeClass
    public static void setUp() {
        baseURI =APP_BASE_URL_HLG;
        //baseURI = EnvUtils.getBaseUrlByEnv();
        enableLoggingOfRequestAndResponseIfValidationFails();

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        requestSpecification = reqBuilder.build();
        reqBuilder.setContentType(ContentType.JSON);
    }

    @After
    public void tearDown(){
        FilterableRequestSpecification req = (FilterableRequestSpecification) requestSpecification;
        req.removeHeader("authorization");
    }
}
