package com.heydoctor.app.domain.dto;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class ReplyDTO {
   Long replyId;
   Long userId;
   Long answerId;
   String replyContent;
   String ReplyRegisterDateiime;
}
