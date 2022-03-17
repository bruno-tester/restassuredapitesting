package utils;

import com.github.javafaker.Faker;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static String getRandomDate(String typeTime, String dateFormat, Integer dateAtMost, Integer dateMinimum) {
        TimeUnit timeUnit = null;
        if (typeTime.equalsIgnoreCase("hours")) timeUnit = TimeUnit.HOURS;
        if (typeTime.equalsIgnoreCase("days")) timeUnit = TimeUnit.DAYS;

        Faker faker = new Faker();
        DateFormat dateFormatChoosed = new SimpleDateFormat(dateFormat);
        return dateFormatChoosed.format(faker.date().future(dateAtMost, dateMinimum, timeUnit));
    }

    public static String getLastDayDate() {
        Calendar cal = Calendar.getInstance();
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1) + "-" + lastDay;
    }

    public static String getTokenInBase64(int customerId, String token) {
        Base64.Encoder encoder = Base64.getEncoder();
        String originalString = customerId + ":" + token;

        return encoder.encodeToString(originalString.getBytes());
    }

    public static String getNewEmail() {
        return "automationtesting" + Utils.getRandomDate("days", "ddMMyyyyHHmmss", 2, 1) + "@qabugs.com";
    }

    public static StringJoiner getConfigsBasePath() {
        String userDir = System.getProperty("user.dir");
        StringJoiner joiner = new StringJoiner(File.separator);

        return joiner
                .add(userDir)
                .add("src")
                .add("test")
                .add("resources");
    }
}