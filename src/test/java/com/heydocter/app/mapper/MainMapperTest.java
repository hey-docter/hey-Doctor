package com.heydocter.app.mapper;

import com.heydoctor.app.HeydocterApplication;
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
    private QuestionMapper questionMapper;

//    커뮤니티 좋아요 순 mapper 테스트
/*    @Test
    public void selectAllTest() {
        log.info(questionMapper.selectLikeDESCAll().toString());
    }*/

//    답변 킹 좋아요 순 mapper 테스트
//    @Test
//    public void selectLikeCountTest() {
//        log.info(mainMapper.selectLikeCount().toString());
//    }
}
