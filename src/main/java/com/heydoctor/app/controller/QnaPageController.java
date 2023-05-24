package com.heydoctor.app.controller;

import com.heydoctor.app.domain.dto.QnaDTO;
import com.heydoctor.app.domain.vo.QnaVO;
import com.heydoctor.app.mapper.QnaMapper;
import com.heydoctor.app.service.adminpage.QnaPageService;
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
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@Component
@RequestMapping("/admin-page/*")
public class QnaPageController {
    private final QnaPageService qnaService;

    //문의글 전체 목록
    @GetMapping("admin")
    public void list(Integer page, HttpSession session, Model model){
        model.addAttribute("qnas", qnaService.getList(page));
//        for(QnaDTO qnaDTO:qnaService.getList(page)){
//            System.out.println(qnaDTO);
//        }
    }

    @GetMapping("qna-page")
    public void goToWriteForm(QnaVO qnaVO){;}

//    게시글 작성
    @PostMapping("qna-page")
    public String write(QnaVO qnaVO){
        qnaService.register(qnaVO);
        return"/main-page/main-page";
//        return new RedirectView("/admin-page/admin");
    }
//
//    상세보기
    @GetMapping("read")
    public void read(Long id, Model model){
        model.addAttribute("qnaId", qnaService.read(id));
    }

    @PostMapping("delete")
    public RedirectView delete(Long id){
        qnaService.deleteQna(id);
        return new RedirectView("/admin-page/admin");
    }

}
