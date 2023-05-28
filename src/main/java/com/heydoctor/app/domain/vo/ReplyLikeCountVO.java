package com.heydoctor.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ReplyLikeCountVO {
    private Long replyLikeCountId;
    private Long userId;
    private Long ReplyId;
}
