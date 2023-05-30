package com.heydoctor.app.controller;

import com.heydoctor.app.domain.dto.*;
import com.heydoctor.app.domain.vo.UserVO;
import com.heydoctor.app.mapper.UserMapper;
import com.heydoctor.app.service.adminpage.AdminpageService;
import com.heydoctor.app.service.question.AnswerService;
import com.heydoctor.app.service.question.QuestionService;
import com.heydoctor.app.service.question.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequiredArgsConstructor
@ComponentScan(basePackages={"com.heydoctor.app.controller"})
@RequestMapping("/admin/*")
public class AdminpageController {
    private final AdminpageService adminpageService;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final ReplyService replyService;
    private final UserMapper userMapper;

    @GetMapping("board-detail")
    public void read(@RequestParam Long questionId, Model model){
//        Optional.ofNullable(questionId).flatMap(adminpageService::read).ifPresent(questionDTO -> {
//            model.addAttribute("question", questionDTO);
////            model.addAttribute("bookmarkedCount", bookmarkedCount);
//        });
        Long userId = 1L;
        Optional.ofNullable(questionId).flatMap(questionService::read).ifPresent(questionDTO -> {
            List<AnswerDTO> answers = answerService.getAllAnswer(0, questionId);
            List<ReplyDTO> replies = replyService.getAllReplyDTO(answers.stream().map(AnswerDTO::getAnswerId).collect(Collectors.toList()));
            UserVO userVO = /*WIP*/userMapper.selectById(userId).get()/*session.getAttribute("user")*/ ;
            Integer answerCount = answerService.getCount(questionId);

            model.addAttribute("question", questionDTO);
            model.addAttribute("user", userVO);
            model.addAttribute("answers", answers);
            model.addAttribute("replies", replies);
            model.addAttribute("answerCount", answerCount);
        });
    }

//    @GetMapping("admin-board-list")
//    public void getList(Integer page, HttpSession session, Model model){
//        Optional.ofNullable(page).flatMap(adminpageService::getList).ifPresent(questionListDTO -> {
////                    model.addAttribute("question", questionListDTO);
//        model.addAttribute("questions", adminpageService.getList(page));
//
//    }
    @GetMapping("admin-board-list")
    public String getList(Pagination pagination, HttpSession session, Search search, Model model){
        pagination.setTotal(adminpageService.getTotal(search));
        pagination.progress();
        model.addAttribute("questions", adminpageService.getList(pagination, search));

        return "/admin-page/admin-board-list";
    }

//
    @GetMapping("delete")
    public RedirectView delete(@RequestParam List<Long> questionId, Model model){
        adminpageService.delete(questionId);
        return new RedirectView("/admin-page/admin-board-list");
    }

}
