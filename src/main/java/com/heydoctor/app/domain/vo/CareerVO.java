package com.heydoctor.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CareerVO {
   private Long careerId;
   private Long doctorId;
   private String careerCategory;
   private String careerContent;


}
