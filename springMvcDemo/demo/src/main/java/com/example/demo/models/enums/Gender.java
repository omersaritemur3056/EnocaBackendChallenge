package com.example.demo.models.enums;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    UNKNOWN("Unknown");

    final String text;

    Gender(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
