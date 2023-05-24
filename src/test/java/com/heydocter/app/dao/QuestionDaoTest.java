package com.heydocter.app.dao;

import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.dao.QuestionDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class QuestionDaoTest {
    @Autowired
    private QuestionDAO questionDAO;

    @Test
    public void findReadDescAllTest() {
        log.info(questionDAO.findReadDescAll().toString());
    }
}
