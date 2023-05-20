package com.heydoctor.app.controller;

import com.heydoctor.app.mapper.QuestionMapper;
import com.heydoctor.app.service.question.QuestionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/question-board/*")
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("detail")
    public void detail(){}

    @GetMapping("write")
    public void goToWriteForm(){}

    @PostMapping("write")
    public void write(){}

    @GetMapping("list")
    public void list(Integer page, Model model){
        model.addAttribute(
                "questions",
                questionService.getList(Optional.ofNullable(page).orElse(0))
        );
    }
}
