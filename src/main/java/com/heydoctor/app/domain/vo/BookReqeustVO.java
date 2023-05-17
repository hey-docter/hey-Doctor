package com.heydoctor.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class BookReqeustVO {
  private Long bookRequestId;
  private Long userId;
  private Boolean isAccepted;
  private String requestDateTime;
  private String requestContent;
  private String userName;
  private String userPhoneNumber;
  private String userEmail;
  private String userAddress;
  private String userDetailAddress;
  private String userDoctorDepartmentType;

}
