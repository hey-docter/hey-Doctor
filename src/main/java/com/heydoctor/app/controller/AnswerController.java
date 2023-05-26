package com.heydoctor.app.controller;

import com.heydoctor.app.domain.dto.AnswerDTO;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.domain.dto.ReplyDTO;
import com.heydoctor.app.domain.enums.DepartmentType;
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
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller @Slf4j
@RequiredArgsConstructor
@RequestMapping("/answer/*")
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final ReplyService replyService;
    private final UserMapper userMapper;
    private final HttpSession session;

    @PostMapping("write")
    @ResponseBody
    public AnswerVO write(AnswerVO answerVO){
        answerService.write(answerVO);
        log.info("==========answerVO: {}", answerVO);
        return answerVO;
    }

    @PostMapping("list/{page}/{name}")
    @ResponseBody
    public List<QuestionListDTO> getAnswerList(@PathVariable Integer page, @PathVariable String name) {
        DepartmentType departmentType = DepartmentType.valueOf(name);
        List<QuestionListDTO> questions = questionService.getList(page, departmentType.name());

        log.info("=========== type: {}", name);
        log.info("=========== page: {}", page);
        log.info("=========== count: {}", questions.size());
        log.info("=======================|");

        return questions;
    }

}
