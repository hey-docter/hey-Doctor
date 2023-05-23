package com.heydoctor.app.controller;

import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.service.adminpage.AdminpageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminpageController {
    private final AdminpageService adminpageService;

//    @GetMapping("admin")
//    public void admin(){ log.info("admin test");
//    }

    @GetMapping("board-detail")
    public void read(@RequestParam Long questionId, Model model){
        Optional.ofNullable(questionId).flatMap(adminpageService::read).ifPresent(questionDTO -> {
            model.addAttribute("question", questionDTO);
//            model.addAttribute("bookmarkedCount", bookmarkedCount);
        });
    }
    @GetMapping("admin-board-list")
    public void list(Integer page, HttpSession session, Model model){
        model.addAttribute("question", adminpageService.getList(page));
    }

//
    @PostMapping("delete")
    public RedirectView remove(Long questionId){
        adminpageService.delete(questionId);
        return new RedirectView("/admin-page/admin-board-list");
    }




}
