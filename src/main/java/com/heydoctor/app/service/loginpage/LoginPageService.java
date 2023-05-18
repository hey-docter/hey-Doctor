package com.heydoctor.app.service.loginpage;

import com.heydoctor.app.domain.vo.UserVO;

import java.util.Optional;

public interface LoginPageService {
    //    아이디 중복검사
    public Optional<UserVO> checkEmail(String userEmail);

    //    회원가입
    public void join(UserVO userVO);

    //    로그인
    public Optional<Long> login(String userEmail, String userPassword);
}
