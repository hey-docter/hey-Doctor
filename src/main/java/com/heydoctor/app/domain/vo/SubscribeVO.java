package com.heydoctor.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class SubscribeVO {
    Long subscribeId;
    Long userId;
    String subscribeRegisterDate;
    String subscribeUpdateDate;
}
