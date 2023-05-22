package com.heydoctor.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class HospitalVO {
    private Long hospitalId;
    private String hospitalName;
    private String hospitalLocation;
}
