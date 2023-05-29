package com.heydoctor.app.controller;


import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.domain.dto.Search;
import com.heydoctor.app.service.searchpage.SearchPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/login/*")
public class SearchController {
    private final SearchPageService searchPageService;

//    @GetMapping("search-list")
//    public String lists(Search search, Model model) {
////        model.addAttribute("keyword", searchPageService.getList(search));
//        model.addAttribute("lists",searchPageService.getList(search));
//        return "login/search-list";
//    }

    @GetMapping("search-list")
    public String list() {
        return "login/search-list";
    }

    @GetMapping("question-list")
    @ResponseBody
    public List<QuestionDTO> QuestionList() {
        System.out.println(" controller");
        System.out.println(searchPageService.getQuestion());
        return searchPageService.getQuestion();
    }

//    @PostMapping("search-list")
//    public RedirectView list(String memberId, String memberPassword, HttpSession session, RedirectAttributes redirectAttributes){
//        final Optional<Long> foundMember = memberService.login(memberId, memberPassword);
//        if(foundMember.isPresent()){
//            session.setAttribute("id", foundMember.get());
//            return new RedirectView("/post/list");
//        }
//        redirectAttributes.addFlashAttribute("login", "fail");
//        return new RedirectView("/member/login");
//    }
}
