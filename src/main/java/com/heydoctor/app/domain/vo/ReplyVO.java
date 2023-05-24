package com.heydoctor.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ReplyVO {
    private Long replyId;
    private Long userId;
    private Long answerId;
    private String replyContent;
    private String replyRegisterDateTime;
}
