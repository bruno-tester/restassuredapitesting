package br.com.restassuredapitesting.tests;

import br.com.restassuredapitesting.base.BaseTest;
import requests.ping.GetPingRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Feature("Feature - Api online")
public class GetPingTest extends BaseTest {

    GetPingRequest getPingRequest = new GetPingRequest();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Verificar se a Api está online")
    public void validaApiOnline(){

        getPingRequest.pingReturnApi()
                .then()
                .statusCode(201);
    }
}