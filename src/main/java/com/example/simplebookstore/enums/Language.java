package com.example.simplebookstore.enums;

public enum Language {
    ENGLISH("English"),
    FRENCH("French"),
    LATIN("Latin"),
    CHINESE("Chinese");

    private final String displayLanguage;

    Language(String displayLanguage){
        this.displayLanguage = displayLanguage;
    }

    public String getDisplayLanguage(){
        return displayLanguage;
    }
}
