package com.demoqa.dataProviders;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StudentData {
    DOB_DAY(
            "04"
    ),
    DOB_MONTH(
            "September"
    ),
    DOB_YEAR(
            "1985"
    ),
    SUBJECT(
            "Physics"
    ),
    HOBBIES(
            "Music"
    ),
    PICTURE_NAME(
            "wil.jpg"
    ),
    STATE_AND_CITY(
            "Haryana Panipat"
    );

    private final String value;
}
