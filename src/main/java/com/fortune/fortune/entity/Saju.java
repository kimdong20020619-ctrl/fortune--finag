package com.fortune.fortune.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Saju {

    // 사주 기둥
    private String yearPillar;   // 연주 (예: 갑자)
    private String monthPillar;  // 월주
    private String dayPillar;    // 일주
    private String hourPillar;   // 시주

    // 오행 비율
    private String fiveElementRatio; // 예: 목30% 화20% 토10% 금20% 수20%

    // 성향, 조언
    private String personality;  // 성격/타입 설명
    private String advice;       // 오늘의 사주 조언
}
