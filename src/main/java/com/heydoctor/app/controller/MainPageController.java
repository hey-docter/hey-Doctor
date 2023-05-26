package com.heydoctor.app.controller;

import com.heydoctor.app.domain.dto.MainDTO;
import com.heydoctor.app.domain.vo.AnswerVO;
import com.heydoctor.app.domain.vo.QuestionVO;
import com.heydoctor.app.domain.vo.ReplyVO;
import com.heydoctor.app.service.mainpage.MainPageService;
import com.heydoctor.app.service.question.AnswerService;
import com.heydoctor.app.service.question.QuestionService;
import com.heydoctor.app.service.question.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/main-page/*")

public class MainPageController {
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final ReplyService replyService;
    private final MainPageService mainPageService;
    private final HttpSession session;

    @GetMapping("main-page")
    public void goToMainPage(Model model){
        List<MainDTO> answers = mainPageService.selectAdopCount();
        List<MainDTO> visits = mainPageService.selectVisitCount();
        List<MainDTO> questions = mainPageService.selectQuestionReadCount();
        List<MainDTO> replies = mainPageService.selectAnswerAll();
        model.addAttribute("answers", answers);
        model.addAttribute("visits", visits);
        model.addAttribute("replies",replies);
        model.addAttribute("questions", questions);
    }

    @GetMapping("loginOk")
    public void loginStatus() {
        Long userId = (Long)session.getAttribute("userId");

    }
    //수정
}
