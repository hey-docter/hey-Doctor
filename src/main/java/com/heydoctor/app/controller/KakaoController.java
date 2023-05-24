package com.heydoctor.app.controller;

import com.heydoctor.app.domain.vo.UserVO;
import com.heydoctor.app.service.loginpage.KakaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;


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



    @RequestMapping(value="/", method= RequestMethod.GET)
    public String index() {
        log.info("home controller");
        return "/login/register";
    }

    @RequestMapping(value="login/naver", method=RequestMethod.GET)
    public String loginPOSTNaver(HttpSession session) {
        log.info("callback controller");
        return "/login/callback";
    }
}