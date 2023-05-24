package com.heydocter.app.service;

import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.service.question.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class QuestionServiceTest {
   @Autowired
    private QuestionService questionService;

   @Test

    public void getListReadCountDescAllTest() {
       log.info(questionService.getListReadCountDescAll().toString());
   }
}
