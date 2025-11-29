package com.fortune.fortune.entity;

public enum ChineseZodiac {

    RAT("쥐"), OX("소"), TIGER("호랑이"), RABBIT("토끼"),
    DRAGON("용"), SNAKE("뱀"), HORSE("말"), GOAT("양"),
    MONKEY("원숭이"), ROOSTER("닭"), DOG("개"), PIG("돼지");

    private final String displayName;

    ChineseZodiac(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public static ChineseZodiac fromYear(int year) {
        int index = (year - 4) % 12;
        return ChineseZodiac.values()[index];
    }
}
