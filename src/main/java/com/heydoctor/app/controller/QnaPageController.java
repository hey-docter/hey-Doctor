package com.heydoctor.app.controller;

import com.heydoctor.app.mapper.QnaMapper;
import com.heydoctor.app.service.adminpage.QnaPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@Component
@RequestMapping("/admin-page/*")

public class QnaPageController {
    private final QnaPageService questionService;

    //문의글 전체 목록
    @GetMapping("admin")
    public void goToQnaList(){;}

    @PostMapping("admin")
    public RedirectView delete(Long QnaId){
        delete(QnaId);
        return new RedirectView("/admin-page/admin");
    }

//    @PostMapping("admin")
//    public RedirectView read(Long QnaId) {
//        read(QnaId);
//        return new RedirectView("/admin-page/board-detail");
//    }

    //게시글 전체 목록
    @GetMapping("admin-board-list")
    public void goToWriteForm(){}

    @PostMapping("write")
    public void write(){}


}
