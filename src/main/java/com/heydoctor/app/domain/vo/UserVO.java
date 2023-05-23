package com.heydoctor.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UserVO {
    private Long userId;
    private String userEmail;
    private String userLoginType;
    private String userName;
    /*휴먼 계정 여부 확인*/
    private Long userIsAvailable;
    private String userPassword;
    private String userType;
    private String userProfilePath;
    private String userProfileName;
    private Long userProfileSize;
    private String userProfileType;
    private String userProfileUuid;

}
