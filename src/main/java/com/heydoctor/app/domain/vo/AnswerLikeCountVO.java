package com.heydoctor.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AnswerLikeCountVO {
    private Long AnswerLikeCountId;
    private Long userId;
    private Long AnswerId;
}
