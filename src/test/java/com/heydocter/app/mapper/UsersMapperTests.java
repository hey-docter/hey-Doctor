package com.heydocter.app.mapper;

import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.domain.vo.UserVO;
import com.heydoctor.app.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class UsersMapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertTest(){
        UserVO userVO = new UserVO();
        userVO.setUserEmail("jin9822@naver.com");
        userVO.setUserLoginType("NOMAL");
        userVO.setUserName("kimjin");
        userVO.setUserIsAvailable(1L);
        userVO.setUserPassword("jin1234");
        userVO.setUserType("ADMIN");
        userVO.setUserProfilePath("");
        userVO.setUserProfileName("");
        userVO.setUserProfileSize(0L);
        userVO.setUserProfileType("");
        userVO.setUserProfileUuid("");
        userMapper.insert(userVO);
    }

    @Test
    public void selectByUserIdTest(){
        Optional<UserVO> foundUser = userMapper.selectByUserEmail("jin9822@naver.com");
        assertThat(foundUser.isPresent()).isEqualTo(true);
    }

    @Test
    public void selectByUserIdAndUserPasswordTest(){
        Optional<Long> foundId = userMapper.selectByUserEmailAndUserPassword("jin9822@naver.com", "jin1234");
        assertThat(foundId.isPresent()).isEqualTo(true);
    }

}
