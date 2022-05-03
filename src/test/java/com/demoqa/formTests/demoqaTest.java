package com.demoqa.formTests;

import com.demoqa.formPages.FormPage;
import com.demoqa.formPages.components.ResultTableFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.demoqa.dataProviders.OtherStudentData.*;
import static com.demoqa.dataProviders.StudentData.*;


public class demoqaTest extends TestSetup {
    FormPage formPage = new FormPage();
    ResultTableFormPage tableFormPage = new ResultTableFormPage();


    @Test
    @DisplayName("Filling out the Student Registration Form")
    void fillFormTest() {
        open("/automation-practice-form");

        formPage.setFirstNameStep(firstName);
        formPage.setLastNameStep(lastName);

        formPage.setMailStep(email);

        formPage.chooseGenderStep(gender);

        formPage.setMobileStep(mobile);

        formPage.setDateOfBirthStep(DOB_MONTH.getValue(), DOB_YEAR.getValue(), DOB_DAY.getValue());

        formPage.setSubjectsStep(SUBJECT.getValue());

        formPage.chooseHobbiesStep();

        formPage.upLoadPictureStep();

        formPage.setCurrentAddressStep(currentAddress);

        formPage.setStateStep();
        formPage.setCityStep();

        formPage.clickOnSubmitStep();

        tableFormPage.checkSubmittedBlockTitleStep();
        tableFormPage.checkResultTableStep(
                firstName,
                lastName,
                email,
                gender,
                mobile,
                DOB_DAY.getValue(),
                DOB_MONTH.getValue(),
                DOB_YEAR.getValue(),
                SUBJECT.getValue(),
                HOBBIES.getValue(),
                PICTURE_NAME.getValue(),
                currentAddress,
                STATE_AND_CITY.getValue()
        );
    }
}
