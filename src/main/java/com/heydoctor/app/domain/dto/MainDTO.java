package com.heydoctor.app.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class MainDTO {
    private Long userId;
    private String userName;
    private String userType;

    private String userProfilePath;
    private String userProfileName;
    private Long userProfileSize;
    private String userProfileType;
    private String userProfileUuid;

    private Long questionId;
    private String questionTitle;
    private String questionContent;
    private String questionRegisterDatetime;
    private Integer questionLikeCount;
    private Integer readCount;

    private Long answerId;
    private String answerTitle;
    private String answerContent;
    private String answerRegisterDatetime;
    private Integer answerLikeCount;

    private Long hospitalId;
    private String doctorIntroduction;
    private String doctorDepartmentType;
    private Long doctorVisitCount;

    private String hospitalName;
    private String hospitalLocation;
    private Long answerCount;


}
