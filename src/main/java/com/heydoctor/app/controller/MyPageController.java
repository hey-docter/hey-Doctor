package com.heydoctor.app.controller;

import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.vo.QuestionVO;
import com.heydoctor.app.service.mypage.MyPageService;
import com.heydoctor.app.service.question.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/mypage/*")
public class MyPageController {
    private final MyPageService myPageService;
    private final HttpSession session;
    //community 작성한 글, 댓글 보기
    @GetMapping("community")
    public void community(Long id, Model model, HttpSession session) {
        model.addAttribute("posts", myPageService.getQuestionList(1L));
//      회원 정보 가져오기
        model.addAttribute("user", myPageService.getUser(1L));
    }



    // 답변
    @GetMapping("community-answer")
    public void communityAnswer(Long id, Model model, HttpSession sessionID ) {
        model.addAttribute("posts", myPageService.getAnswerList(1L));
        //      회원 정보 가져오기
        model.addAttribute("user", myPageService.getUser(1L));
    }

    // 댓글
    @GetMapping("community-reply")
    public void communityReply(Long id, Model model, HttpSession session ) {
        model.addAttribute("posts", myPageService.getReplyList(1L));
        //      회원 정보 가져오기
        model.addAttribute("user", myPageService.getUser(1L));
    }



    //스테이터스
    @GetMapping("essay")
    public void essay(Long id, Model model, HttpSession session ) {
        //      회원 정보 가져오기
        model.addAttribute("user", myPageService.getUser(1L));
        log.info("essay");
    }

    // 회원탈퇴
    @GetMapping("quit")
    public void quit(Long id, Model model, HttpSession session ) {
        //      회원 정보 가져오기
        model.addAttribute("user", myPageService.getUser(1L));
        log.info("quit");
    }

    //예약목록
    @GetMapping("reservation-list")
    public void reservationList(Long id, Model model, HttpSession session ) {
        //      회원 정보 가져오기
        model.addAttribute("user", myPageService.getUser(1L));
        log.info("reservation-list");
    }

    //개인 정보 설정
    @GetMapping("setting")
    public void setting(Long id, Model model, HttpSession session ) {
        //      회원 정보 가져오기
        model.addAttribute("user", myPageService.getUser(1L));
        log.info("setting");
    }

    //구독관리
    @GetMapping("subscribe")
    public void subscribe(Long id, Model model, HttpSession session ) {
        //      회원 정보 가져오기
        model.addAttribute("user", myPageService.getUser(1L));
        log.info("subscribe");
    }

    //이력 작성(마이페이지에서 이력 클릭시 이동)
    @GetMapping("resume")
    public void resume(Long id, Model model, HttpSession session ) {
        log.info("resume");
    }

    //이력 목록
    @GetMapping("resume-control")
    public void resumeControl(Long id, Model model, HttpSession session ){log.info("resume-control");}

    //이력 수정
    @GetMapping("resume-edit")
    public void resumeEdit(Long id, Model model, HttpSession session ){log.info("resume-edit");}
}

