package com.heydoctor.app.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class UserVO {
    private Long id;
    private String userId;
    private String userEmail;
    private String userLoginType;
    private String userName;
    /*휴먼계정 여부 확인*/
    private Long userIsAvailable;
    private String userPassword;
    private String userType;
    private String userProfileName;
    private String userProfileSize;
    private String userProfileOriginName;
    private String userProfileUuid;

}
