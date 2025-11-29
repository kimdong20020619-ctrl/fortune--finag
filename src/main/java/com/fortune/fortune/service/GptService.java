package com.fortune.fortune.service;

import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GptService {

    private final OpenAiService openAiService;

    public GptService(@Value("${openai.api-key}") String apiKey) {
        this.openAiService = new OpenAiService(apiKey);
    }

    public String generateFortune(String zodiac, String chinese, String gender,
                                  String birthDate, String birthTime,
                                  String category) {

        String prompt = """
                너는 전문 운세가이다.
                아래 정보를 기반으로 매우 자연스럽고 고퀄리티의 운세를 생성해라.

                [입력 정보]
                - 별자리: %s
                - 띠: %s
                - 성별: %s
                - 생년월일: %s
                - 태어난 시간: %s
                - 운세 종류: %s

                [출력 형식]
                총운:
                애정운:
                금전운:
                직장/비즈니스:
                건강운:
                행운의 색:
                행운의 숫자:
                행운의 아이템:
                """.formatted(zodiac, chinese, gender, birthDate, birthTime, category);

        var completion = openAiService.createChatCompletion(
                com.theokanning.openai.completion.chat.ChatCompletionRequest.builder()
                        .model("gpt-4o-mini")
                        .messages(java.util.List.of(
                                new com.theokanning.openai.completion.chat.ChatMessage("system", "너는 세계 최고 수준의 전문 운세가이다."),
                                new com.theokanning.openai.completion.chat.ChatMessage("user", prompt)
                        ))
                        .maxTokens(600)
                        .temperature(0.7)
                        .build()
        );

        return completion.getChoices().get(0).getMessage().getContent();
    }
}
