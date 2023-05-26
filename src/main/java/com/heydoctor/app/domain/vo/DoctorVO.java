package com.heydoctor.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class DoctorVO {
  private Long userId;
  private Long hospitalId;
  private String doctorCertificationId;
  private Boolean isBookable;
  private String doctorIntroduction;

  private String doctorDepartmentType;

  private String doctorVisitCount;
}
