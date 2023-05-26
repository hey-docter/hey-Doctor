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
public class KakaoController {
    private final LoginPageService loginPageService;
    private final KakaoService kakaoService;

    @Autowired
    public KakaoController(LoginPageService loginPageService, KakaoService kakaoService) {
        this.loginPageService = loginPageService;
        this.kakaoService = kakaoService;
    }

    //카카오
    @ResponseBody
    @GetMapping("/login/kakao")
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
                if (user.getUserLoginType().equals("NOMAL") || user.getUserLoginType().equals("NAVER")) {
                    log.info("일반이나 네이버아이디 있음");
                    return new RedirectView("/login/register?login=false");
                }
                else if (user.getUserLoginType().equals("KAKAO")) {
                    Optional<UserVO> foundUser2 = loginPageService.checkEmail(kakaoUser.getUserEmail());
                    redirectAttributes.addFlashAttribute("userId", foundUser2.get().getUserId());
                    log.info("카카오 아이디가 이미 존재함");
                    log.info("세션: {}", foundUser2.get().getUserId());
                    session.setAttribute("userId", foundUser2.get().getUserId());
                    return new RedirectView("/main-page/main-page");
                }
            }

            loginPageService.join(kakaoUser);
            Optional<UserVO> foundUser2 = loginPageService.checkEmail(kakaoUser.getUserEmail());
            Long value = foundUser2.get().getUserId();

            session.setAttribute("userId", foundUser2.get().getUserId());
            log.info("세션2: {}", foundUser2.get().getUserId());


        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("login", "fail-kakao");
            return new RedirectView("/login/register");
        }
        return new RedirectView("/main-page/main-page");
    }
    @GetMapping("/logout/kakao")
    public RedirectView kakaoLogout(HttpSession session){
        log.info("logout");
        kakaoService.logoutKakao((String)session.getAttribute("token"));
        session.invalidate();
        return new RedirectView("/login/login-start");
    }
}