package com.heydoctor.app.controller;


import com.heydoctor.app.service.meetdoctor.MeetDoctorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/MeetDoctor/*")
public class MeetDoctorController {
    private final MeetDoctorService meetDoctorService;
    @GetMapping("MeetDoctor")
    public void MeetDoctor(){ log.info("MeetDoctor test");
    }
}
