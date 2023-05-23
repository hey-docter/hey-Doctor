package com.heydoctor.app.controller;

import com.heydoctor.app.domain.dto.AnswerDTO;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.domain.dto.ReplyDTO;
import com.heydoctor.app.domain.vo.AnswerVO;
import com.heydoctor.app.domain.vo.QuestionVO;
import com.heydoctor.app.domain.vo.ReplyVO;
import com.heydoctor.app.domain.vo.UserVO;
import com.heydoctor.app.mapper.UserMapper;
import com.heydoctor.app.service.question.AnswerService;
import com.heydoctor.app.service.question.QuestionService;
import com.heydoctor.app.service.question.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller @Slf4j
@RequiredArgsConstructor
@RequestMapping("/question-board/*")
public class QuestionController {
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final ReplyService replyService;
    private final UserMapper userMapper;
    private final HttpSession session;

    @GetMapping("detail")
    public void read(@RequestParam Long questionId, Model model){
        Long userId = 1L;
        Optional.ofNullable(questionId).flatMap(questionService::read).ifPresent(questionDTO -> {
            List<AnswerDTO> answers = answerService.getAllAnswer(questionId);
            List<ReplyDTO> replies = replyService.getAllReplyDTO(answers.stream().map(AnswerDTO::getAnswerId).collect(Collectors.toList()));
            UserVO userVO = /*WIP*/userMapper.selectById(userId).get()/*session.getAttribute("user")*/ ;

            model.addAttribute("question", questionDTO);
            model.addAttribute("user", userVO);
            model.addAttribute("answers", answers);
            model.addAttribute("replies", replies);
        });
    }

    @GetMapping("write")
    public void goToWriteForm(QuestionVO questionVO){}

    @PostMapping("question/write")
    public void write(QuestionVO questionVO){}

    @PostMapping("answer/write")
    public void write(AnswerVO answerVO){}

    @PostMapping("reply/write")
    public void write(ReplyVO replyVO){}

    @GetMapping("list")
    public void list(Integer page, Model model){
        Long userId = 1L/*(Long) session.getAttribute("userId")*/;
        List<QuestionListDTO> questions = questionService.getList(Optional.ofNullable(page).orElse(0));
        // userService WIP
        Optional.ofNullable(userId).flatMap(/*WIP*/userMapper::selectById)/*session.getAttribute("user")*/
                .ifPresent(userVO -> model.addAttribute("userVO", userVO));
        model.addAttribute("questions", questions);
    }
}
