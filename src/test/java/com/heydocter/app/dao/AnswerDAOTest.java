package com.heydocter.app.dao;

import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.dao.AnswerDAO;
import com.heydoctor.app.domain.dto.AnswerDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class AnswerDAOTest {
    @Autowired
    private AnswerDAO answerDAO;

    @Test
    public void findByAdoptCountTest() {
        log.info(answerDAO.findByAdoptCount().toString());
    }
}
