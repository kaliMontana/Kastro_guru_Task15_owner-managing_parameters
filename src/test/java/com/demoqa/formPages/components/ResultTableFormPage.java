package com.demoqa.formPages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.demoqa.util.Helper.format;

public class ResultTableFormPage {
    public static final String SUBMITTED_FORM_TITLE = "Thanks for submitting the form";
    public static final String STUDENT_NAME = "Student Name";
    public static final String STUDENT_MAIL = "Student Email";
    public static final String GENDER = "Gender";
    public static final String MOBILE = "Mobile";
    public static final String DATA_OF_BIRTH = "Date of Birth";
    public static final String SUBJECTS = "Subjects";
    public static final String HOBBIES = "Hobbies";
    public static final String PICTURE = "Picture";
    public static final String ADDRESS = "Address";
    public static final String STATE_AND_CITY = "State and City";

    SelenideElement titleSubmittedFormElement = $("#example-modal-sizes-title-lg");
    ElementsCollection resultRowElements = $$(".table-responsive tr");


    public void checkSubmittedBlockTitleStep() {
        Assertions.assertThat(titleSubmittedFormElement.shouldBe(visible).getText())
                .as("Ошибка проверки заголовки запольненого бланка.")
                .isEqualTo(SUBMITTED_FORM_TITLE);
    }

    public void checkResultTableStep(
            String firstName,
            String lastName,
            String mail,
            String gender,
            String mobile,
            String day,
            String month,
            String year,
            String subjects,
            String hobbies,
            String pictureName,
            String currentAddress,
            String StateAndCity) {
        String DATA_OF_BIRTH_FORMAT = format("{} {},{}", day, month, year);

        SoftAssertions softAssertions = new SoftAssertions();

        for (int i = 1; i < resultRowElements.size(); i++) {
            if (resultRowElements.get(i).$$("td").get(0).getText().equals(STUDENT_NAME)) {
                softAssertions.assertThat(resultRowElements.get(i).$$("td").get(1).getText())
                        .as("Ошибка проверки имени студянта")
                        .isEqualTo(firstName + " " + lastName);
            } else if (resultRowElements.get(i).$$("td").get(0).getText().equals(STUDENT_MAIL)) {
                softAssertions.assertThat(resultRowElements.get(i).$$("td").get(1).getText())
                        .as("Ошибка проверки email")
                        .isEqualTo(mail);
            } else if (resultRowElements.get(i).$$("td").get(0).getText().equals(GENDER)) {
                softAssertions.assertThat(resultRowElements.get(i).$$("td").get(1).getText())
                        .as("Ошибка проверки пола")
                        .isEqualTo(gender);
            } else if (resultRowElements.get(i).$$("td").get(0).getText().equals(MOBILE)) {
                softAssertions.assertThat(resultRowElements.get(i).$$("td").get(1).getText())
                        .as("Ошибка проверки mobile")
                        .isEqualTo(mobile);
            } else if (resultRowElements.get(i).$$("td").get(0).getText().equals(DATA_OF_BIRTH)) {
                softAssertions.assertThat(resultRowElements.get(i).$$("td").get(1).getText())
                        .as("Ошибка проверки дня рождения")
                        .isEqualTo(DATA_OF_BIRTH_FORMAT);
            } else if (resultRowElements.get(i).$$("td").get(0).getText().equals(SUBJECTS)) {
                softAssertions.assertThat(resultRowElements.get(i).$$("td").get(1).getText())
                        .as("Ошибка проверки придмета")
                        .isEqualTo(subjects);
            } else if (resultRowElements.get(i).$$("td").get(0).getText().equals(HOBBIES)) {
                softAssertions.assertThat(resultRowElements.get(i).$$("td").get(1).getText())
                        .as("Ошибка проверки hobby")
                        .isEqualTo(hobbies);
            } else if (resultRowElements.get(i).$$("td").get(0).getText().equals(PICTURE)) {
                softAssertions.assertThat(resultRowElements.get(i).$$("td").get(1).getText())
                        .as("Ошибка проверки изображения")
                        .isEqualTo(pictureName);
            } else if (resultRowElements.get(i).$$("td").get(0).getText().equals(ADDRESS)) {
                softAssertions.assertThat(resultRowElements.get(i).$$("td").get(1).getText())
                        .as("Ошибка проверки адреса")
                        .isEqualTo(currentAddress);
            } else if (resultRowElements.get(i).$$("td").get(0).getText().equals(STATE_AND_CITY)) {
                softAssertions.assertThat(resultRowElements.get(i).$$("td").get(1).getText())
                        .as("Ошибка проверки штата и города")
                        .isEqualTo(StateAndCity);
            }

            softAssertions.assertAll();
        }
    }
}
