package com.heydoctor.app.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AnswerDTO {
    private Long answerId;
    private Long userId;
    private String answerTitle;
    private String answerRegisterDatetime;
    private String question_title;
}
