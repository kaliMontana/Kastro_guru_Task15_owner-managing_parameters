package com.demoqa.formPages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.demoqa.util.Helper.format;

public class CalendarComponentPage {
    SelenideElement dateOfBirthInput = $("input[id=dateOfBirthInput]");
    SelenideElement monthElement = $(".react-datepicker__month-select");
    SelenideElement yearElement = $(".react-datepicker__year-select");

    private final String PATTERN_SELECTOR = ".react-datepicker__day--0{}:not(.react-datepicker__day--outside-month)";

    public void setDate(String month, String year, String day) {
        dateOfBirthInput.shouldBe(enabled).click();

        monthElement.selectOption(month);
        yearElement.shouldBe(enabled).selectOption(year);
        $(format(PATTERN_SELECTOR, day)).shouldBe(enabled).click();
    }
}
