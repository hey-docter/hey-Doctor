package com.heydocter.app.mapper;

import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.enums.DepartmentType;
import com.heydoctor.app.domain.enums.QuestionType;
import com.heydoctor.app.domain.vo.QuestionVO;
import com.heydoctor.app.domain.vo.UserVO;
import com.heydoctor.app.mapper.QuestionMapper;
import com.heydoctor.app.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class QuestionMapperTests {

    @Autowired
    private QuestionMapper questionMapper;

    @Test
    public void selectListTest() {
        QuestionVO questionVO = new QuestionVO();
        questionVO.setQuestionContent("test content");
        questionVO.setQuestionIsPublic(QuestionType.PUBLIC.isPublic());
        questionVO.setQuestionTitle("test title");
        questionVO.setUserId(1L);
        questionVO.setDoctorDepartmentType(DepartmentType.MENTAL_HEALTH.getType());

        //IntStream.range(0, 10).forEach(i -> questionMapper.insert(questionVO));

        assertThat(questionMapper.selectList(0).size()).isEqualTo(10);
    }

    @Test
    public void selectOneTest() {
        assertThat(questionMapper.selectOne(4L)).isNotNull();
    }

    @Test
<<<<<<< HEAD
    public void selectReadDESCAllTest() {
        log.info(questionMapper.selectReadDESCAll().toString());
    }
=======
    public void updateTest() {
        QuestionDTO questionDTO = questionMapper.selectOne(4L);
        questionMapper.updateReadCount(4L);
        assertThat(questionMapper.selectOne(4L).getReadCount())
                .isEqualTo(questionDTO.getReadCount() + 1);
    }

>>>>>>> 4fbae7e845994c5cd2265e1f5e2fbf3b10507312
}
