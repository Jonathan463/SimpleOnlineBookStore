package com.example.simplebookstore.enums;

public enum Category {
    SCIENCE_AND_TECHNOLOGY("Science and Technology"),
    RELIGIOUS_AND_SPIRITUAL("Religious and Spiritual"),
    ROMANCE("Romance"),
    BUSINESS_AND_ECONOMICS("Business and Economics"),
    ARTS_AND_HUMANITIES("Arts and Humanities"),
    HEALTH_AND_WELLNESS("Health and Wellness"),
    EDUCATIONAL("Educational");

    private final String displayName;

    Category(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
