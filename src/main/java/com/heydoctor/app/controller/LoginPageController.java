package com.heydoctor.app.controller;

import com.heydoctor.app.domain.vo.UserVO;
import com.heydoctor.app.service.loginpage.KakaoService;
import com.heydoctor.app.service.loginpage.LoginPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/login/*")
public class LoginPageController {
    private final LoginPageService loginPageService;
    private final KakaoService kakaoService;

    @Autowired
    public LoginPageController(LoginPageService loginPageService, KakaoService kakaoService) {
        this.loginPageService = loginPageService;
        this.kakaoService = kakaoService;
    }
    //    이메일 중복검사
    @GetMapping("check-email/{userEmail}")
    @ResponseBody
    public boolean checkId(@PathVariable String userEmail){
        return loginPageService.checkEmail(userEmail).isPresent();
    }

//    회원가입
    @GetMapping("register")
    public void goToJoinForm(UserVO userVO){;}

    @PostMapping("register")
    public RedirectView join(UserVO userVO){
        userVO.setUserLoginType("NOMAL");
        loginPageService.join(userVO);
        return new RedirectView("/login/login");
    }



//    로그인 스타트 이동
    @GetMapping("login-start")
    public void goToLoginStartForm(){;}

//    로그인
    @GetMapping("login")
    public void goToLoginForm(UserVO userVO){;}

    @PostMapping("login")
    public RedirectView login(String userEmail, String userPassword, HttpSession session, RedirectAttributes redirectAttributes) {
        final Optional<Long> foundUser = loginPageService.login(userEmail, userPassword);
        if (foundUser.isPresent()) {
            if (userEmail.equals("8888") && userPassword.equals("8888")) {
                // 이메일과 비밀번호가 "8888"인 경우 관리자 페이지로 이동
                return new RedirectView("/admin-page/admin");
            }
            //성공 메인페이지 이동
            session.setAttribute("userId", foundUser.get());
            return new RedirectView("/main-page/main-page");
        }
        //로그인 실패시 로그인 페이지
        redirectAttributes.addFlashAttribute("login", "fail");
        return new RedirectView("/login/login");
    }


    //    로그아웃
    @GetMapping("logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/login/login-start");
    }

//카카오
    @ResponseBody
    @GetMapping("/kakao")
    public RedirectView kakaoCallback(@RequestParam String code, HttpSession session, RedirectAttributes redirectAttributes) {
        log.info("Kakao code: " + code);
        String token = kakaoService.getKaKaoAccessToken(code);
        session.setAttribute("token", token);

        try {
            UserVO kakaoUser = kakaoService.getKakaoInfo(token);

            if (kakaoUser == null) {
                redirectAttributes.addFlashAttribute("login", "fail-kakao-non-email");
                return new RedirectView("/login/login");
            }

            Optional<UserVO> foundUser = loginPageService.checkEmail(kakaoUser.getUserEmail());

            if (foundUser.isPresent()) {
                UserVO user = foundUser.get();
                if (user.getUserLoginType().equals("NOMAL")) {
                    redirectAttributes.addFlashAttribute("login", "already-exist-NORMAL");
                    return new RedirectView("/login/login");
                } else if (user.getUserLoginType().equals("NAVER")) {
                    redirectAttributes.addFlashAttribute("login", "already-exist-NAVER");
                    return new RedirectView("/login/login");
                } else if (user.getUserLoginType().equals("KAKAO")) {
                    // Update user data if it's a Kakao account
                    kakaoUser.setUserId(user.getUserId());
                    log.info(kakaoUser.toString());
                    session.setAttribute("userId", user.getUserId());
                    return new RedirectView("/main-page/main-page");
                }
            }

            loginPageService.join(kakaoUser);

            Optional<Long> foundIdOptional = loginPageService.login(kakaoUser.getUserEmail(), kakaoUser.getUserPassword());
            Long foundId = foundIdOptional.orElse(null);

            session.setAttribute("userId", foundId);
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("login", "fail-kakao");
            return new RedirectView("/login/login");
        }

        return new RedirectView("/main-page/main-page");
    }
}
