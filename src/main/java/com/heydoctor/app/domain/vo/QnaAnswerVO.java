package com.heydoctor.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class QnaAnswerVO {
    private Long qnaAnswerId;
    private Long userId;
    private Long qnaId;
    private String qnaAnswerTitle;
    private String qnaAnswerContent;
    private String qnaAnswerRegisterDateTime;

    private Long answerCount;
    private String userName;
}
