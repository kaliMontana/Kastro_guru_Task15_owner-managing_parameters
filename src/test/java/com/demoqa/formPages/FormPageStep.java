package com.demoqa.formPages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.demoqa.formPages.components.CalendarComponentPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormPageStep {
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
    SelenideElement optionCityElement = $("#react-select-4-option-0");
    SelenideElement submitElement = $("#submit");

    private static final String IMG_PATH = "img/wil.jpg";

    CalendarComponentPage calendarComponent = new CalendarComponentPage();


    @Step("Открыть страницу бланка")
    public void openFormPageStep() {
        open("/automation-practice-form");
    }

    @Step("Вводить имя студента {firstName}")
    public void setFirstNameStep(String firstName) {
        firstNameElement.shouldBe(enabled).setValue(firstName);
    }

    @Step("Вводить фамилю студента {lastName}")
    public void setLastNameStep(String lastName) {
        lastNameElement.shouldBe(enabled).setValue(lastName);
    }

    @Step("Вводить email {email}")
    public void setMailStep(String email) {
        mailElement.shouldBe(enabled).setValue(email);
    }

    @Step("Вводить пол студента {gender}")
    public void chooseGenderStep(String gender) {
        genderElement.$(byText(gender)).click();
    }

    @Step("Вводить номер сотобого телефона {userNumber}")
    public void setMobileStep(String userNumber) {
        mobilElement.shouldBe(enabled).setValue(userNumber);
    }

    @Step("Вводить дата рождения студента {month} {year} {day}")
    public void setDateOfBirthStep(String month, String year, String day) {
        dateOfBirthElement.shouldBe(enabled).click();
        calendarComponent.setDate(month, year, day);
    }

    @Step("Вводить придмет изучения {subject}")
    public void setSubjectsStep(String subject) {
        subjectElement.shouldBe(enabled).setValue(subject).pressEnter();
    }

    @Step("Вывирать увлечения")
    public void chooseHobbiesStep() {
        hobbiesElement.parent().click();
    }

    @Step("Загрузить изовражение")
    public void upLoadPictureStep() {
        uploadPictureElement.uploadFromClasspath(IMG_PATH);
    }

    @Step("Вводить текуший адрес {currentAddress}")
    public void setCurrentAddressStep(String currentAddress) {
        addressElement.click();
        addressElement.setValue(currentAddress);
    }

    @Step("Вывирать штат")
    public void setStateStep() {
        stateElement.click();
        optionStateElement.click();
    }

    @Step("Вывирать город")
    public void setCityStep() {
        cityElement.click();
        optionCityElement.click();
    }

    @Step("Отправить запольненую форму")
    public void clickOnSubmitStep() {
        submitElement.click();

        attachScreenShot();
    }

    @Attachment(value = "ScreenShot", type = "image/png", fileExtension = "png")
    public byte[] attachScreenShot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
