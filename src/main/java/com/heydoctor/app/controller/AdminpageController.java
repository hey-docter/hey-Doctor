package com.heydoctor.app.controller;

import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.domain.dto.Search;
import com.heydoctor.app.service.adminpage.AdminpageService;
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

@Controller
@Slf4j
@RequiredArgsConstructor
@ComponentScan(basePackages={"com.heydoctor.app.controller"})
@RequestMapping("/admin/*")
public class AdminpageController {
    private final AdminpageService adminpageService;

    @GetMapping("board-detail")
    public void read(@RequestParam Long questionId, Model model){
        Optional.ofNullable(questionId).flatMap(adminpageService::read).ifPresent(questionDTO -> {
            model.addAttribute("question", questionDTO);
//            model.addAttribute("bookmarkedCount", bookmarkedCount);
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
    @PostMapping("delete")
    public RedirectView delete(List<Long> questionId, Model model){
        adminpageService.delete(questionId);
        return new RedirectView("/admin-page/admin-board-list");
    }

}
