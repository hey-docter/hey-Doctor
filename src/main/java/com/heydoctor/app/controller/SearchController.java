package com.heydoctor.app.controller;


import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.domain.dto.Search;
import com.heydoctor.app.domain.vo.BookReqeustVO;
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
@RequestMapping("/search/*")
public class SearchController {
    private final SearchPageService searchPageService;

//    @GetMapping("search-list")
//    public String lists(Search search, Model model) {
////        model.addAttribute("keyword", searchPageService.getList(search));
//        model.addAttribute("lists",searchPageService.getList(search));
//        return "login/search-list";
//    }

    @GetMapping("search-list")
    public void list(Pagination pagination, Search search, Model model) {
        pagination.setTotal(searchPageService.getTotal(search));
        model.addAttribute("questions", searchPageService.getTotal(search));
    }

    @GetMapping("question-list")
    @ResponseBody
    public List<QuestionDTO> getQuestionList(String keyword) {
        Search search = new Search();
        search.setKeyword(keyword);
//        System.out.println(" controller");
//        System.out.println(searchPageService.getQuestion());
        return searchPageService.getList(search);
    }

    //전체 조회
    @GetMapping("question-total")
    @ResponseBody
    public void questionTotal(Pagination pagination, Search search, Model model) {
//        pagination.setTotal(searchPageService.getTotal());
        model.addAttribute("questions", searchPageService.getTotal(search));
    }


    @GetMapping("reservation-list")
    @ResponseBody
    public List<BookReqeustVO> getReservationList(String keyword) {
        Search search = new Search();
        search.setKeyword(keyword);
//        System.out.println(" controller");
//        System.out.println(searchPageService.getQuestion());
        return searchPageService.getBookList(search);
    }

    //전체 조회
    @GetMapping("reservation-total")
    @ResponseBody
    public void ReservationTotal(Pagination pagination, Search search, Model model) {
//        pagination.setTotal(searchPageService.getTotal());
        model.addAttribute("reservations", searchPageService.getTotal(search));
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
