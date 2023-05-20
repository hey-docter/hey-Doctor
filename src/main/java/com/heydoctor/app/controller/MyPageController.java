package com.heydoctor.app.controller;

import com.heydoctor.app.service.mypage.MyPageService;
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

    @GetMapping("viewAll")
    public void viewAll(){ log.info("viewAll");
    }
    //community 작성한 질문 글 보기
    @GetMapping("qeustionView")
    public void qeustionView(){ log.info("qeustionView");
    }
    //community 작성한 댓글 보기
    @GetMapping("replyView")
    public void replyView(){ log.info("replyView");
    }
    //이력
    @GetMapping("introduction")
    public void introduction(){ log.info("introduction");
    }
}
