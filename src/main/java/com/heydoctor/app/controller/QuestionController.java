package com.heydoctor.app.controller;

import com.heydoctor.app.domain.dto.AnswerDTO;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.domain.dto.ReplyDTO;
import com.heydoctor.app.domain.enums.DepartmentType;
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
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    public void goToWriteForm(QuestionVO questionVO){;}

    @PostMapping("write")
    public RedirectView write(QuestionVO questionVO){
        questionVO.setUserId(1L /*session.getAttribute("id")*/);
        questionService.write(questionVO);
        //log.info("==========ID: {}", questionVO.getQuestionId());
        return new RedirectView("/question-board/list");
    }

    @PostMapping("reply/write")
    @ResponseBody
    public void write(ReplyVO replyVO){

    }

    @GetMapping("list")
    public void list(Model model){
        Long userId = 1L/*(Long) session.getAttribute("userId")*/;
        // userService WIP
        Optional.ofNullable(userId).flatMap(/*WIP*/userMapper::selectById)/*session.getAttribute("user")*/
                .ifPresent(userVO -> model.addAttribute("userVO", userVO));
    }

    @PostMapping("question/list/{page}/{name}")
    @ResponseBody
    public List<QuestionListDTO> getQuestionList(@PathVariable Integer page, @PathVariable String name) {
        DepartmentType departmentType = DepartmentType.valueOf(name);
        List<QuestionListDTO> questions = questionService.getList(page, departmentType.name());

        log.info("=========== type: {}", name);
        log.info("=========== page: {}", page);
        log.info("=========== count: {}", questions.size());
        log.info("=======================|");

        return questions;
    }

    @PostMapping("reply/list/{page}/{name}")
    @ResponseBody
    public List<QuestionListDTO> getReplyList(@PathVariable Integer page, @PathVariable String name) {
        DepartmentType departmentType = DepartmentType.valueOf(name);
        List<QuestionListDTO> questions = questionService.getList(page, departmentType.name());

        log.info("=========== type: {}", name);
        log.info("=========== page: {}", page);
        log.info("=========== count: {}", questions.size());
        log.info("=======================|");

        return questions;
    }
}
