package tests;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class TestData {
    Faker faker = new Faker(new Locale("fr"));
    Random random = new Random();

    String username = faker.name().firstName(),
            userLastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = randomGender(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            birthDay = String.valueOf(faker.number().numberBetween(1, 31)),
            birthMonth = randomMonth(),
            birthYear = String.valueOf(faker.number().numberBetween(1980, 2023)),
            subject = "English",
            hobby = randomHobby(),
            photo = "src/test/resources/avatar.png",
            address = faker.lebowski().quote(),
            state = "Haryana",
            city = "Karnal";

    public String randomMonth() {
        String[] arrayMonth = {"January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December"};
        return arrayMonth[random.nextInt(arrayMonth.length)];
    }

    public String randomHobby() {
        String[] arrayHobby = {"Sports", "Reading", "Music"};
        return arrayHobby[random.nextInt(arrayHobby.length)];
    }

    public String randomGender() {
        String[] arrayGender = {"Male", "Female", "Other"};
        return arrayGender[random.nextInt(arrayGender.length)];
    }
}
