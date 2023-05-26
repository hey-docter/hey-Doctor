package com.heydoctor.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class SubscribeVO {
   private Long subscribeId;
   private Long userId;
   private String subscribeRegisterDate;
   private String subscribeUpdateDate;
}
