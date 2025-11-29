package com.fortune.fortune.repository;

import com.fortune.fortune.entity.Fortune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FortuneRepository extends JpaRepository<Fortune, Long> {
    // ❗ 기존 findByZodiacAndChineseAndCategory 이런 메서드 전부 삭제하기
}
