package com.heydoctor.app.controller;

import com.heydoctor.app.domain.vo.UserVO;
import com.heydoctor.app.service.loginpage.LoginPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/login/*")
public class LoginPageController {
    private final LoginPageService loginPageService;

//    회원가입
    @GetMapping("register")
    public void goToJoinForm(UserVO userVO){;}

    @PostMapping("register")
    public RedirectView join(UserVO userVO){
        loginPageService.join(userVO);
        return new RedirectView("/login/login");
    }

//    로그인 스타트 이동
    @GetMapping("login-start")
    public void goToLoginStartForm(UserVO userVO){;}

//    로그인
    @GetMapping("login")
    public void goToLoginForm(UserVO userVO){;}

    @PostMapping("login")
    public String login(String userEmail, String userPassword, HttpSession session){
        final Optional<Long> foundUser = loginPageService.login(userEmail, userPassword);
        if(foundUser.isPresent()){
            session.setAttribute("id", foundUser.get());
            return "/main-page/main-page";
        }
        return "/login/login?login=false";
    }

    //    로그아웃
    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/login/login-start");
    }

}
