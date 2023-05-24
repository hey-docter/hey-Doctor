package com.heydoctor.app.controller;

import com.heydoctor.app.domain.vo.AnswerVO;
import com.heydoctor.app.domain.vo.QuestionVO;
import com.heydoctor.app.domain.vo.ReplyVO;
import com.heydoctor.app.service.question.AnswerService;
import com.heydoctor.app.service.question.QuestionService;
import com.heydoctor.app.service.question.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/main-page/*")

public class MainPageController {
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final ReplyService replyService;

    @GetMapping("main-page")
    public void goToMainPage(Model model){
        List<QuestionVO> questions = questionService.getListReadCountDescAll();
        List<ReplyVO> replies = replyService.getAllAnswerReply();
        List<AnswerVO> answers = answerService.getListDoctorListAll();
        model.addAttribute("questions",questions);
        model.addAttribute("replies", replies);
        model.addAttribute("answers", answers);
    }
    //수정

}
