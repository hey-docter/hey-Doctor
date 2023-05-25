package com.heydoctor.app.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ReplyDTO {
    private Long replyId;
    private Long userId;
    private Long answerId;
    private String replyContent;
    private String replyRegisterDateTime;

    private String userName;
    private String userProfilePath;
    private String userProfileName;
    private Long userProfileSize;
    private String userProfileType;
    private String userProfileUuid;

    private String answerContent;
    private String questionTitle;
}
