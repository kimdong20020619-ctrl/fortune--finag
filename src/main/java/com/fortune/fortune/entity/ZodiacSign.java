package com.fortune.fortune.entity;

import java.time.LocalDate;
import java.time.MonthDay;

public enum ZodiacSign {

    ARIES("양자리", MonthDay.of(3, 21), MonthDay.of(4, 19)),
    TAURUS("황소자리", MonthDay.of(4, 20), MonthDay.of(5, 20)),
    GEMINI("쌍둥이자리", MonthDay.of(5, 21), MonthDay.of(6, 21)),
    CANCER("게자리", MonthDay.of(6, 22), MonthDay.of(7, 22)),
    LEO("사자자리", MonthDay.of(7, 23), MonthDay.of(8, 22)),
    VIRGO("처녀자리", MonthDay.of(8, 23), MonthDay.of(9, 23)),
    LIBRA("천칭자리", MonthDay.of(9, 24), MonthDay.of(10, 22)),
    SCORPIO("전갈자리", MonthDay.of(10, 23), MonthDay.of(11, 22)),
    SAGITTARIUS("사수자리", MonthDay.of(11, 23), MonthDay.of(12, 24)),
    CAPRICORN("염소자리", MonthDay.of(12, 25), MonthDay.of(1, 19)),
    AQUARIUS("물병자리", MonthDay.of(1, 20), MonthDay.of(2, 18)),
    PISCES("물고기자리", MonthDay.of(2, 19), MonthDay.of(3, 20));

    private final String displayName;
    private final MonthDay start;
    private final MonthDay end;

    ZodiacSign(String displayName, MonthDay start, MonthDay end) {
        this.displayName = displayName;
        this.start = start;
        this.end = end;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    // 날짜로 별자리 계산
    public static ZodiacSign fromDate(LocalDate date) {
        MonthDay md = MonthDay.from(date);

        for (ZodiacSign z : values()) {
            if (isBetween(md, z.start, z.end)) {
                return z;
            }
        }
        return CAPRICORN; // fallback
    }

    private static boolean isBetween(MonthDay today, MonthDay start, MonthDay end) {
        if (start.isBefore(end) || start.equals(end)) {
            return !today.isBefore(start) && !today.isAfter(end);
        } else {
            return !today.isBefore(start) || !today.isAfter(end);
        }
    }
}
