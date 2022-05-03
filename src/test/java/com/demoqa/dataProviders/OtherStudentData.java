package com.demoqa.dataProviders;

import com.github.javafaker.Faker;


public class OtherStudentData {
    static Faker faker = new Faker();

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            mobile = faker.phoneNumber().subscriberNumber(10),
            currentAddress = faker.address().fullAddress();
}
