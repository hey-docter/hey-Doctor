package com.heydoctor.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class QuestionLikeCountVO {
    private Long QuestionLikeCountId;
    private Long userId;
    private Long QuestionId;
}
