package com.heydoctor.heydoctor.controller;

import com.heydoctor.heydoctor.domain.service.mypage.MyPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/MyPage/*")
public class MyPageController {
    private final MyPageService myPageService;
    @GetMapping("MyPage")
    public void MyPage(){ log.info("MyPage test");
    }
}
