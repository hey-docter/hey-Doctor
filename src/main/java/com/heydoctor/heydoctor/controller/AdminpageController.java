package com.heydoctor.heydoctor.controller;

import com.heydoctor.heydoctor.domain.service.adminpage.AdminpageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/*")
public class AdminpageController {
    private final AdminpageService adminpageService;
    @GetMapping("admin")
    public void admin(){ log.info("admin test");
    }


}
