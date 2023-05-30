package com.heydoctor.app.controller;

import com.heydoctor.app.domain.dto.ReplyDTO;
import com.heydoctor.app.domain.vo.QuestionBookmarkVO;
import com.heydoctor.app.domain.vo.ReplyVO;
import com.heydoctor.app.service.question.QuestionBookmarkService;
import com.heydoctor.app.service.question.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @Slf4j
@RequiredArgsConstructor
@RequestMapping("/bookmark/*")
public class BookmarkController {
    private final QuestionBookmarkService questionBookmarkService;

    @PostMapping("question/add")
    public void addQuestionBookmark(@RequestBody QuestionBookmarkVO questionBookmarkVO){
        questionBookmarkService.setQuestionBookmarkVO(questionBookmarkVO);
    }

    @PostMapping("reply/add/")
    public void addReplyBookmark(@RequestBody QuestionBookmarkVO questionBookmarkVO){
        questionBookmarkService.setQuestionBookmarkVO(questionBookmarkVO);
    }

}
