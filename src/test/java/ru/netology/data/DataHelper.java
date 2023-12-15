package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataHelper {
    public static String getValidActiveCard() {
        return ("4444 4444 4444 4441");
    }

    public static String getValidInactiveCard() {
        return ("4444 4444 4444 4442");
    }

    public static String getInvalidCardNumber() {
        return ("4444 4444 4444 4440");
    }

    public static String getLongCardNumber() {
        return ("4444 4444 4444 44410");
    }

    public static String getShortCardNumber() {
        return ("4444 4444 4444 444");
    }

    public static LocalDate generateValidPeriod() {
        Faker faker = new Faker();
        long addDays = faker.number().numberBetween(1, 1_827);
        return LocalDate.now().plusDays(addDays);
    }

    public static String generateValidMonth() {
        return generateValidPeriod().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateInvalidMonth() {
        int max = 99;
        return String.valueOf(Math.random() * ++max) + 0;
    }

    public static String generateValidYear() {
        return generateValidPeriod().format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generateCurrentYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }

    public static LocalDate generateExpiredPeriod() {
        Faker faker = new Faker();
        long subDays = faker.number().numberBetween(1, 1_000);
        return LocalDate.of(Integer.parseInt(generateCurrentYear()), 1, 1).minusDays(subDays);
    }

    public static String generateExpiredYear() {
        return generateExpiredPeriod().format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generateExpiredMonth() {
        return generateExpiredPeriod().format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String generateInvalidYear() {
        Faker faker = new Faker();
        long addDays = faker.number().numberBetween(1_827, 10_000);
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generateValidHolderInEn() {
        Faker faker = new Faker(new Locale("en"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String generateValidHolderInRu() {
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String generateStringInEn(int quaint) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = quaint;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String generateStringInRu(int quaint) {
        int leftLimit = 128; // letter 'А'
        int rightLimit = 159; // letter 'Я'
        int targetStringLength = quaint;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String generateValidCVCCode() {
        Faker faker = new Faker();
        return String.valueOf(faker.number().numberBetween(100, 899));
    }

    public static String generateSymbol() {
        Random r = new Random();
        char symbol = 0;
        String alphabet = "!@#$%^&*()/}{:?><";
        for (int i = 0; i < 50; i++) {
            symbol = alphabet.charAt(r.nextInt(alphabet.length()));
        }
        return String.valueOf(symbol);
    }

    public static String generateNumbers(int count) {
        Faker faker = new Faker();
        long value = faker.number().randomNumber(count, true);
        return String.valueOf(value);
    }

}
