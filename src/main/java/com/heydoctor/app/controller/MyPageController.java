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
@RequestMapping("/mypage/*")
public class MyPageController {
    private final MyPageService myPageService;

    //community 작성한 글, 댓글 보기
    @GetMapping("community")
    public void community() {
        log.info("community");
    }

    //스테이터스
    @GetMapping("essay")
    public void essay() {
        log.info("essay");
    }

    // 회원탈퇴
    @GetMapping("quit")
    public void quit() {
        log.info("quit");
    }

    //예약목록
    @GetMapping("reservation-list")
    public void reservationList() {
        log.info("reservation-list");
    }

    //개인 정보 설정
    @GetMapping("setting")
    public void setting() {
        log.info("setting");
    }

    //구독관리
    @GetMapping("subscribe")
    public void subscribe() {
        log.info("subscribe");
    }

    //이력 작성(마이페이지에서 이력 클릭시 이동)
    @GetMapping("resume")
    public void resume() {
        log.info("resume");
    }

    //이력 목록
    @GetMapping("resume-control")
    public void resumeControl(){log.info("resume-control");}

    //이력 수정
    @GetMapping("resume-edit")
    public void resumeEdit(){log.info("resume-edit");}
}

