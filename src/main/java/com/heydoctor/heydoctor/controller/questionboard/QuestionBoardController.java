package com.heydoctor.heydoctor.controller.questionboard;

import com.heydoctor.heydoctor.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/QuestionBoard/*")
public class QuestionBoardController {
    private final QuestionMapper questionMapper;
    @GetMapping("QuestionBoard")
    public void QuestionBoard(){ log.info("QuestionBoard test");
    }
}
