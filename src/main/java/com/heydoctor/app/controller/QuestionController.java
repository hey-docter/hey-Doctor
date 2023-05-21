package com.heydoctor.app.controller;

import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.mapper.UserMapper;
import com.heydoctor.app.service.question.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/question-board/*")
public class QuestionController {
    private final QuestionService questionService;
    private final UserMapper userMapper;

    @GetMapping("detail")
    public void read(@RequestParam Long questionId, @RequestParam Integer bookmarkedCount, Model model){
        log.info("okaeri");
        Optional.ofNullable(questionId).flatMap(questionService::read).ifPresent(questionDTO -> {
            log.info("tadaima");
            model.addAttribute("question", questionDTO);
            model.addAttribute("bookmarkedCount", bookmarkedCount);
        });
    }

    @GetMapping("write")
    public void goToWriteForm(){}

    @PostMapping("write")
    public void write(){}

    @GetMapping("list")
    public void list(Integer page, HttpSession session, Model model){
        Long userId = 1L/*(Long) session.getAttribute("userId")*/;
        List<QuestionListDTO> questions = questionService.getList(Optional.ofNullable(page).orElse(0));

        // userService WIP
        Optional.ofNullable(userId).flatMap(/*WIP*/userMapper::selectById)
                .ifPresent(userVO -> model.addAttribute("userVO", userVO));

        model.addAttribute("questions", questions);
    }
}
