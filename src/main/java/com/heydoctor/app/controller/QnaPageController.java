package com.heydoctor.app.controller;

import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.dto.QnaDTO;
import com.heydoctor.app.domain.dto.Search;
import com.heydoctor.app.domain.vo.QnaVO;
import com.heydoctor.app.domain.vo.QuestionVO;
import com.heydoctor.app.mapper.QnaMapper;
import com.heydoctor.app.service.adminpage.QnaPageService;
import com.heydoctor.app.service.loginpage.LoginPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@Component
@RequestMapping("/qna/*")
public class QnaPageController {
    private final QnaPageService qnaService;
    private final LoginPageService loginPageService;

    //문의글 전체 목록
    @GetMapping("admin")
    public String list(Pagination pagination, HttpSession session, Search search, Model model){
        pagination.setTotal(qnaService.getTotal(search));
        pagination.progress();
        model.addAttribute("qnas", qnaService.getList(pagination, search));
        return "/admin-page/admin";
    }
    @GetMapping("qna-page")
    public String goToWriteForm(QnaVO qnaVO, HttpSession session, Model model){
//        model.addAttribute("userName", loginPageService.getUser((Long)session.getAttribute("userId")).get().getUserName());
        qnaVO.setUserId(1L /*session.getAttribute("id")*/);
        model.addAttribute("userId", 1L);
        return "/admin-page/qna-page";
    }

    @PostMapping("qna-page")
    public RedirectView write(QnaVO qnaVO){
        qnaService.register(qnaVO);
        return new RedirectView("/main-page/main-page");
    }

//    @GetMapping("qna-page")
//    public String goToWriteForm(QnaVO qnaVO){
//        return "/admin-page/qna-page";
//
//    }

//    게시글 작성
//    @PostMapping("qna-page")
//    public String write(QnaVO qnaVO){
//        qnaService.register(qnaVO);
//        return"/main-page/main-page";
////        return new RedirectView("/admin-page/admin");
//    }
//
//    상세보기
    @GetMapping("read")
    public void read(Long id, Model model){
        model.addAttribute("qnaId", qnaService.read(id));
    }

    @PostMapping("delete")
    public RedirectView delete(List<Long> qnaId){
        qnaService.deleteQna(qnaId);
        return new RedirectView("/admin-page/admin");
    }


}
