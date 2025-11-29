package com.fortune.fortune.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Fortune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 카테고리 (TODAY / TOMORROW / WEEK / MONTH / YEAR 등)
    private String category;

    // 총운
    @Column(length = 1000)
    private String summary;

    // 애정운
    @Column(length = 1000)
    private String love;

    // 금전운
    @Column(length = 1000)
    private String money;

    // 직장·비즈니스 운
    @Column(length = 1000)
    private String job;

    // 건강운
    @Column(length = 1000)
    private String health;

    // 행운 요소
    private String luckyColor;
    private String luckyItem;
    private String luckyNumber;

    // ⭐ 운세 점수 (1~100)
    private Integer score;
}
