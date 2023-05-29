package com.heydoctor.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
public class QuestionBookmarkVO {
    private Long questionBookmarkId;
    private Long userId;
    private Long questionId;
}
