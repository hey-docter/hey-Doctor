package com.heydoctor.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PayVO {
    private Long payId;
    private Long subscribeId;
    private Long payPrice;
}
