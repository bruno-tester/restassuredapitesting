package utils.dataprovider;

import exceptions.ConfigurationReaderFileException;
import exceptions.PropertyInfoException;
import lombok.extern.slf4j.Slf4j;
import utils.EnvUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import static utils.Utils.getConfigsBasePath;

@Slf4j
public class ConfigFileReader {

    protected static final Properties properties = new Properties();

    public ConfigFileReader() {
        String env = "hlg";
        String propertyPathName = "configuration-" + env.toLowerCase(Locale.ROOT) + ".properties";
        String propertyFilePath = getConfigsBasePath().add(propertyPathName).toString();
        log.info("\n######\nSelecionando o arquivo " + propertyPathName + "  para massa de dados.\n######");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(propertyFilePath), StandardCharsets.UTF_8))) {
            try {
                properties.load(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ConfigurationReaderFileException("Configuration.properties not found at " + propertyFilePath, e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getInfo(String property){
        try {
            return properties.getProperty(property);
        } catch (Exception e){
            throw new PropertyInfoException( property + " not found.", e);
        }
    }

    public static List<String> getImgFicAdminFid(String brand, String journey){
        List<String> list = new ArrayList<>();
        String imgHome = "";
        String imgCar = "";
        String imgCheckout = "";

        if(brand.equalsIgnoreCase("pa") &&
                journey.equalsIgnoreCase("FIRST_PURCHASE")){
            imgHome = properties.getProperty("img_home_pa_first_purchase");
            imgCar = properties.getProperty("img_car_pa_first_purchase");
            imgCheckout = properties.getProperty("img_checkout_pa_first_purchase");
            list.add(imgHome);
            list.add(imgCar);
            list.add(imgCheckout);
        }

        if(brand.equalsIgnoreCase("pa") &&
                journey.equalsIgnoreCase("PRE_APPROVED")){
            imgHome = properties.getProperty("img_home_pa_pre_approved");
            imgCar = properties.getProperty("img_car_pa_pre_approved");
            imgCheckout = properties.getProperty("img_checkout_pa_pre_approved");
            list.add(imgHome);
            list.add(imgCar);
            list.add(imgCheckout);
        }

        if(brand.equalsIgnoreCase("ex") &&
                journey.equalsIgnoreCase("FIRST_PURCHASE")){
            imgHome = properties.getProperty("img_home_ex_first_purchase");
            imgCar = properties.getProperty("img_car_ex_first_purchase");
            imgCheckout = properties.getProperty("img_checkout_ex_first_purchase");
            list.add(imgHome);
            list.add(imgCar);
            list.add(imgCheckout);
        }

        if(brand.equalsIgnoreCase("ex") &&
                journey.equalsIgnoreCase("PRE_APPROVED")){
            imgHome = properties.getProperty("img_home_ex_pre_approved");
            imgCar = properties.getProperty("img_car_ex_pre_approved");
            imgCheckout = properties.getProperty("img_checkout_ex_pre_approved");
            list.add(imgHome);
            list.add(imgCar);
            list.add(imgCheckout);
        }

        return list;
    }
}