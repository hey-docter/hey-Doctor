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
    private String userNAme;
    /*구독 여부 확인*/
    private String userIsAvailable;
    private String userPassword;
    /*휴먼계정 여부 확인*/
    private String userIsSubscribe;
    private String userType;
    private String userProfileName;
    private String userProfileSize;
    private String userProfileOriginName;
    private String userProfileUuid;
}
