package com.heydocter.app.dao;

import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.dao.ReplyDAO;
import com.heydoctor.app.domain.vo.ReplyVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class ReplyDAOTest {
    @Autowired
    private ReplyDAO replyDAO;

    @Test
    public void findAllAnswerReplyTest() {
        log.info(replyDAO.findAllAnswerReply().toString());
    }
}
