package com.heydoctor.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class QuestionVO {
    Long questionId;
    Long userId;
    String questionTitle;
    String questionContent;
    String questionRegisterDateTime;
    Boolean questionIsPublic;
    Long questionLikeCount;
    String doctorDepartmentType;
    Long readCount;
}
