package com.heydoctor.heydoctor.model.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/model/*")
@Slf4j
public class ModelController {

    @GetMapping("model")
    public void model(){
        log.info("model test");
    }

}
