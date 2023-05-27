package com.heydoctor.app.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class LikeDTO {
    private Long QuestionLikeCountId;
    private Long AnswerLikeCountId;
    private Long ReplyLikeCountId;
    private Long UserId;
    private Long DoctorVisitCount;
    private Long AnswerIsAdopted;

}
