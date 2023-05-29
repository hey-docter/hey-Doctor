package com.heydoctor.app.controller;

import com.heydoctor.app.domain.dto.AnswerDTO;
import com.heydoctor.app.domain.dto.ReplyDTO;
import com.heydoctor.app.domain.vo.AnswerVO;
import com.heydoctor.app.domain.vo.ReplyVO;
import com.heydoctor.app.mapper.UserMapper;
import com.heydoctor.app.service.question.AnswerService;
import com.heydoctor.app.service.question.QuestionService;
import com.heydoctor.app.service.question.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController @Slf4j
@RequiredArgsConstructor
@RequestMapping("/reply/*")
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("write")
    public ReplyDTO write(@RequestBody ReplyVO replyVO){
        return replyService.write(replyVO);
    }

    @GetMapping("list/{answerId}/{page}")
    public List<ReplyDTO> getReplyList(@PathVariable Integer page, @PathVariable Long answerId) {
        return null;
    }

}
