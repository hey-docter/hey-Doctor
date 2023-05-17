package com.heydoctor.heydoctor.controller.login;

import com.heydoctor.heydoctor.domain.service.inter.LoginPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/login/*")
public class LoginPageController {
    private final LoginPageService loginPageService;
    @GetMapping("login")
    public void login(){ log.info("login test");
    }

}
