package com.heydocter.app.mapper;

import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.mapper.AnswerMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class AnswerMapperTests {

    @Autowired
    private AnswerMapper answerMapper;

    @Test
    public void selectByQuestionIdTest() {
        assertThat(answerMapper.selectByQuestionId(6L)).isNotNull();
    }

}
