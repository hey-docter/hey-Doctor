package com.heydoctor.app.controller;

import com.heydoctor.app.domain.vo.UserVO;
import com.heydoctor.app.service.loginpage.KakaoService;
import com.heydoctor.app.service.loginpage.LoginPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;


@Controller
@RequiredArgsConstructor
@Slf4j
public class KakaoController {
    private final KakaoService kakaoService;

//    @ResponseBody
//    @GetMapping("/login/kakao")
//    public RedirectView  kakaoCallback(UserVO userVO, @RequestParam String code, HttpSession session) throws Exception {
//        log.info(code);
//        String token = kakaoService.getKaKaoAccessToken(code);
//        session.setAttribute("token", token);
//        kakaoService.getKakaoInfo(token);
//        return new RedirectView("/login/register");
//    }

    @GetMapping("/logout/kakao")
    public RedirectView kakaoLogout(HttpSession session){
        log.info("logout");
        kakaoService.logoutKakao((String)session.getAttribute("token"));
        session.invalidate();
        return new RedirectView("/login/register");
    }



}