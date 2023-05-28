package com.heydocter.app.service;

import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.service.mainpage.MainPageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class MainServiceTest {
@Autowired
    private MainPageService mainPageService;

    /*@Test
    public void selectReadCountTest(){
        log.info(mainPageService.selectReadCount().toString());
    }*/

    @Test
    public void selectQuestionReadCountTest(){
        log.info(mainPageService.selectQuestionReadCount().toString());
    }

    @Test
    public void selectAnswerAllTest(){
        log.info(mainPageService.selectAnswerAll().toString());
    }

    @Test
    public void selectAdopCountTest(){
        log.info(mainPageService.selectAdopCount().toString());
    }

    @Test
    public void selectVisitCount() {
        log.info(mainPageService.selectVisitCount().toString());
    }
}
