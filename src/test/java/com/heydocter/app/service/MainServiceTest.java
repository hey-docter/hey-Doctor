package com.heydocter.app.service;

import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.service.mainpage.MainPageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class MainServiceTest {
    @Autowired
    private MainPageService mainPageService;

    @Test
    public void getListAllTest(){
        log.info(mainPageService.getListAll().toString());
    }

    @Test
    public void getListLikeDESCAllTest() {
        log.info(mainPageService.getListLikeDESCAll().toString());
    }
}
