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
    private String questionTitle;
    private Long questionId;

    private String answerTitle;
    private String answerContent;
    private String answerRegisterDateTime;
    private Boolean answerIsPublic;
    private Integer answerLikeCount;
    private Boolean answerIsAdopted;

    private String doctorName;
    private Double adoptedAnswerPercent;
    private String doctorDepartmentType;
    private String hospitalName;
}
