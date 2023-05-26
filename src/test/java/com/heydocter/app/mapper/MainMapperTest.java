package com.heydocter.app.mapper;

import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.mapper.MainMapper;
import com.heydoctor.app.mapper.QuestionMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class MainMapperTest {
    @Autowired
    private MainMapper mainMapper;

    @Test
    public void selectReadCountTest() {
        log.info(mainMapper.selectReadCount().toString());
    }

    @Test
    public void selectAdoptCountTest() {
        log.info(mainMapper.selectAdoptCount().toString());
    }

    @Test
    public void selectVisitCountTest(){
        log.info(mainMapper.selectVisitCount().toString());
    }

}
