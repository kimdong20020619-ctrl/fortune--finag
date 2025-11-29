package com.fortune.fortune.service;

import com.fortune.fortune.entity.ChineseZodiac;
import com.fortune.fortune.entity.Fortune;
import com.fortune.fortune.entity.ZodiacSign;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FortuneService {

    // 오늘
    public Fortune getToday(ZodiacSign zodiac, ChineseZodiac chinese, String gender, String birthTime, String calendarType) {
        return buildFortune(zodiac, chinese, "TODAY", gender, birthTime, calendarType);
    }

    // 내일
    public Fortune getTomorrow(ZodiacSign zodiac, ChineseZodiac chinese, String gender, String birthTime, String calendarType) {
        return buildFortune(zodiac, chinese, "TOMORROW", gender, birthTime, calendarType);
    }

    // 이번 주
    public Fortune getWeek(ZodiacSign zodiac, ChineseZodiac chinese, String gender, String birthTime, String calendarType) {
        return buildFortune(zodiac, chinese, "WEEK", gender, birthTime, calendarType);
    }

    // 이달
    public Fortune getMonth(ZodiacSign zodiac, ChineseZodiac chinese, String gender, String birthTime, String calendarType) {
        return buildFortune(zodiac, chinese, "MONTH", gender, birthTime, calendarType);
    }

    // 올해
    public Fortune getYear(ZodiacSign zodiac, ChineseZodiac chinese, String gender, String birthTime, String calendarType) {
        return buildFortune(zodiac, chinese, "YEAR", gender, birthTime, calendarType);
    }

    // 별자리 계산
    public ZodiacSign getZodiac(LocalDate date) {
        int m = date.getMonthValue();
        int d = date.getDayOfMonth();

        if ((m == 3 && d >= 21) || (m == 4 && d <= 19)) return ZodiacSign.ARIES;
        if ((m == 4 && d >= 20) || (m == 5 && d <= 20)) return ZodiacSign.TAURUS;
        if ((m == 5 && d >= 21) || (m == 6 && d <= 21)) return ZodiacSign.GEMINI;
        if ((m == 6 && d >= 22) || (m == 7 && d <= 22)) return ZodiacSign.CANCER;
        if ((m == 7 && d >= 23) || (m == 8 && d <= 22)) return ZodiacSign.LEO;
        if ((m == 8 && d >= 23) || (m == 9 && d <= 23)) return ZodiacSign.VIRGO;
        if ((m == 9 && d >= 24) || (m == 10 && d <= 22)) return ZodiacSign.LIBRA;
        if ((m == 10 && d >= 23) || (m == 11 && d <= 22)) return ZodiacSign.SCORPIO;
        if ((m == 11 && d >= 23) || (m == 12 && d <= 24)) return ZodiacSign.SAGITTARIUS;
        if ((m == 12 && d >= 25) || (m == 1 && d <= 19)) return ZodiacSign.CAPRICORN;
        if ((m == 1 && d >= 20) || (m == 2 && d <= 18)) return ZodiacSign.AQUARIUS;
        return ZodiacSign.PISCES;
    }

    // 띠 계산
    public ChineseZodiac getChineseZodiac(LocalDate date) {
        String[] animals = {
                "MONKEY","ROOSTER","DOG","PIG","RAT","OX",
                "TIGER","RABBIT","DRAGON","SNAKE","HORSE","GOAT"
        };
        return ChineseZodiac.valueOf(animals[date.getYear() % 12]);
    }

    // 운세 Generator
    private Fortune buildFortune(ZodiacSign zodiac, ChineseZodiac chinese, String category,
                                 String gender, String birthTime, String calendarType) {

        int seed = Math.abs((zodiac.ordinal()+1)*37
                + (chinese.ordinal()+1)*19
                + category.hashCode()
                + birthTime.hashCode());

        // 점수 20~95 사이 난수 생성 (카테고리별로 자동 다름)
        int score = 20 + (seed % 75);

        Fortune fortune = new Fortune();
        fortune.setSummary("오늘의 총운은 안정적이며 기회가 다가오는 흐름입니다.");
        fortune.setLove("사랑에서 작은 감정 변화가 크게 느껴지는 날입니다.");
        fortune.setMoney("금전적으로 과소비를 주의할 필요가 있습니다.");
        fortune.setJob("직장과 비즈니스에서 협업이 강조되는 하루입니다.");
        fortune.setHealth("몸의 컨디션 관리를 잘 해야 하는 시기입니다.");

        fortune.setLuckyColor("파스텔 블루");
        fortune.setLuckyItem("핸드크림");
        fortune.setLuckyNumber("7");
        fortune.setScore(score);

        return fortune;
    }
}
