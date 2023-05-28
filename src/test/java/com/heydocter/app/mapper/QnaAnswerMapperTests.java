package com.heydocter.app.mapper;

import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.domain.enums.DepartmentType;
import com.heydoctor.app.domain.vo.AnswerVO;
import com.heydoctor.app.domain.vo.DoctorVO;
import com.heydoctor.app.domain.vo.HospitalVO;
import com.heydoctor.app.domain.vo.QnaAnswerVO;
import com.heydoctor.app.mapper.AnswerMapper;
import com.heydoctor.app.mapper.DoctorMapper;
import com.heydoctor.app.mapper.QnaAnswerMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class QnaAnswerMapperTests {

    @Autowired
    private QnaAnswerMapper qnaAnswerMapper;

    @Test
    public void insertTest() {
        QnaAnswerVO qnaAnswerVO = new QnaAnswerVO();
        qnaAnswerVO.setQnaAnswerContent("test content1");
        qnaAnswerVO.setQnaId(21L);
        qnaAnswerVO.setQnaAnswerTitle("test title1");
        qnaAnswerVO.setUserId(1L);

        qnaAnswerMapper.insert(qnaAnswerVO);

        qnaAnswerVO.setQnaAnswerContent("test content1");
        qnaAnswerVO.setQnaId(41L);
        qnaAnswerVO.setQnaAnswerTitle("test title1");
        qnaAnswerVO.setUserId(1L);

        qnaAnswerMapper.insert(qnaAnswerVO);

        qnaAnswerVO.setQnaAnswerContent("test content1");
        qnaAnswerVO.setQnaId(41L);
        qnaAnswerVO.setQnaAnswerTitle("test title1");
        qnaAnswerVO.setUserId(1L);

        qnaAnswerMapper.insert(qnaAnswerVO);

    }

    @Test
    public void selectByQuestionIdsTest() {
        assertThat(qnaAnswerMapper.selectByQnaId(41L).size()).isEqualTo(2);
    }

}
