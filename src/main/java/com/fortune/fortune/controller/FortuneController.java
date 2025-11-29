package com.fortune.fortune.controller;

import com.fortune.fortune.entity.ChineseZodiac;
import com.fortune.fortune.entity.Fortune;
import com.fortune.fortune.entity.ZodiacSign;
import com.fortune.fortune.service.FortuneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
@RequestMapping("/fortune")
public class FortuneController {

    private final FortuneService fortuneService;

    // 첫 화면
    @GetMapping("")
    public String index() {
        return "fortune/index";
    }

    // 운세 결과 처리
    @PostMapping("/result")
    public String getFortuneResult(
            @RequestParam("birth") String birth,
            @RequestParam("gender") String gender,
            @RequestParam("birthTime") String birthTime,
            @RequestParam("calendar") String calendarType,
            @RequestParam("category") String category,
            Model model) {

        LocalDate date = LocalDate.parse(birth);

        ZodiacSign zodiac = fortuneService.getZodiac(date);
        ChineseZodiac chinese = fortuneService.getChineseZodiac(date);

        Fortune fortune;

        switch (category) {
            case "TOMORROW" -> fortune = fortuneService.getTomorrow(zodiac, chinese, gender, birthTime, calendarType);
            case "WEEK" -> fortune = fortuneService.getWeek(zodiac, chinese, gender, birthTime, calendarType);
            case "MONTH" -> fortune = fortuneService.getMonth(zodiac, chinese, gender, birthTime, calendarType);
            case "YEAR" -> fortune = fortuneService.getYear(zodiac, chinese, gender, birthTime, calendarType);
            default -> fortune = fortuneService.getToday(zodiac, chinese, gender, birthTime, calendarType);
        }

        // model에 값 전달
        model.addAttribute("fortune", fortune);
        model.addAttribute("zodiac", zodiac.getDisplayName());
        model.addAttribute("chinese", chinese.getDisplayName());

        model.addAttribute("category", category);
        model.addAttribute("birthDate", birth);
        model.addAttribute("birthTime", birthTime);
        model.addAttribute("gender", gender);
        model.addAttribute("calendarType", calendarType);

        return "fortune/result";
    }
}
