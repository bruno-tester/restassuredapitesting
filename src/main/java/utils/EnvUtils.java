package utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Locale;

import static utils.Constants.*;
@Slf4j
public class EnvUtils {

    public enum Env {
        DEV2, HLG, PROD
    }

    public static String getBaseUrlByEnv(){
        String baseUrl = null;
        final Env env = Env.valueOf(getEnv());

        switch (env) {
            case HLG:
                baseUrl = APP_BASE_URL_HLG;
                break;
            case DEV2:
                baseUrl = APP_BASE_URL_DEV;
                break;
            case PROD:
                baseUrl = APP_BASE_URL_PROD;
                break;
            default:
                throw new AssertionError("Base url does not exist or is not configured!");
        }
        log.info("\n######\nIniciando os testes para o ambiente: " + env + " e para url: " + baseUrl + "\n######");
        return baseUrl;
    }

    public static String getEnv() {
        if (System.getProperty("env").length() > 0) {
            return System.getProperty("env").toUpperCase(Locale.ROOT);
        } else {
            log.error("A variável -Denv não está configurada corretamente em seus testes, considere revisar.");
            return "HLG";
        }
    }
}