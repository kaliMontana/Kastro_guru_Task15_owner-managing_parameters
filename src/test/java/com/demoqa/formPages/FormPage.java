package com.demoqa.formPages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.formPages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FormPage {
    SelenideElement firstNameElement = $("#firstName");
    SelenideElement lastNameElement = $("#lastName");
    SelenideElement mailElement = $("#userEmail");
    SelenideElement genderElement = $("#genterWrapper");
    SelenideElement mobilElement = $("#userNumber");
    SelenideElement dateOfBirthElement = $("#dateOfBirthInput");
    SelenideElement subjectElement = $("#subjectsInput");
    SelenideElement hobbiesElement = $("#hobbies-checkbox-3");
    SelenideElement uploadPictureElement = $("#uploadPicture");
    SelenideElement addressElement = $("textarea[class=form-control]");
    SelenideElement stateElement = $("#state");
    SelenideElement optionStateElement = $("#react-select-3-option-2");
    SelenideElement cityElement = $("#city");
    SelenideElement optionCityElement = $("#react-select-4-option-1");
    SelenideElement submitElement = $("#submit");

    private static final String IMG_PATH = "img/wil.jpg";

    CalendarComponent calendarComponent = new CalendarComponent();


    public void setFirstNameStep(String firstName) {
        firstNameElement.shouldBe(enabled).setValue(firstName);
    }

    public void setLastNameStep(String lastName) {
        lastNameElement.shouldBe(enabled).setValue(lastName);
    }

    public void setMailStep(String email) {
        mailElement.shouldBe(enabled).setValue(email);
    }

    public void chooseGenderStep(String gender) {
        genderElement.$(byText(gender)).click();
    }

    public void setMobileStep(String userNumber) {
        mobilElement.shouldBe(enabled).setValue(userNumber);
    }

    public void setDateOfBirthStep(String month, String year, String day) {
        dateOfBirthElement.shouldBe(enabled).click();
        calendarComponent.setDate(month, year, day);
    }

    public void setSubjectsStep(String subject) {
        subjectElement.shouldBe(enabled).setValue(subject).pressEnter();
    }

    public void chooseHobbiesStep() {
        hobbiesElement.parent().click();
    }

    public void upLoadPictureStep() {
        uploadPictureElement.uploadFromClasspath(IMG_PATH);
    }

    public void setCurrentAddressStep(String currentAddress) {
        addressElement.click();
        addressElement.setValue(currentAddress);
    }

    public void setStateStep() {
        stateElement.click();
        optionStateElement.click();
    }

    public void setCityStep() {
        cityElement.click();
        optionCityElement.click();
    }

    public void clickOnSubmitStep() {
        submitElement.click();
    }
}
