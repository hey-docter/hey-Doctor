package com.heydoctor.app.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class DoctorDTO {
    private Long userId;
    private Integer questionLikeCount;
    private Integer answerLikeCount;
    private Integer replyLikeCount;
    private String doctorVisitCount;
}
