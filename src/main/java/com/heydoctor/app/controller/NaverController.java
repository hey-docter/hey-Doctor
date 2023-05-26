package com.heydoctor.app.controller;

import com.heydoctor.app.domain.vo.UserVO;
import com.heydoctor.app.mapper.UserMapper;
import com.heydoctor.app.service.loginpage.LoginPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@Slf4j
public class NaverController {

    @Autowired
    private LoginPageService loginPageService;
    private final UserMapper userMapper;


    @GetMapping("/login/navera")
    @ResponseBody
    public String joinNaver(@RequestParam(value="email", required=false) String email,@RequestParam(value="name", required=false)String name,@RequestParam(value="id", required=false) String id, HttpSession session) {
        log.info("들옴");
        UserVO userVO = new UserVO();


        Optional<UserVO> foundId = loginPageService.checkEmail(email);
        if(foundId.isPresent()){
            if (foundId.get().getUserLoginType().equals("KAKAO") || foundId.get().getUserLoginType().equals("NOMAL") ) {
                log.info("카카오나 일반으로 가입되어있음");
                return "/login/register";
            }else{
                userMapper.naverUpdate(userVO);
                Optional<UserVO> newid = loginPageService.checkEmail(email);
                session.setAttribute("id", newid.get().getUserId());
                log.info("로그인되면서 업데이트됨");
                log.info("세션: {}", newid.get().getUserId());
                return "/main-page/main-page";
            }
        }

        userVO.setUserLoginType("NAVER");
        userVO.setUserEmail(email);
        userVO.setUserPassword(id);
        userVO.setUserName(name);
        loginPageService.join(userVO);
        Optional<UserVO> newid2 = loginPageService.checkEmail(email);
        session.setAttribute("id",newid2.get().getUserId());
        log.info("회원가입됨");
        return "/main-page/main-page";
    }

    @GetMapping("/logout/naver")
    public RedirectView naverLogout(HttpSession session){
        log.info("logout");
        session.invalidate();
        return new RedirectView("/login/login-start");
    }
}
