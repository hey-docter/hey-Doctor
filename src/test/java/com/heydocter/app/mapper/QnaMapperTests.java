package com.heydocter.app.mapper;


import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.domain.enums.DepartmentType;
import com.heydoctor.app.domain.enums.QuestionType;
import com.heydoctor.app.domain.vo.QnaVO;
import com.heydoctor.app.domain.dto.QnaDTO;
import com.heydoctor.app.domain.vo.QuestionVO;
import com.heydoctor.app.mapper.QnaMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class QnaMapperTests {

    @Autowired
    private QnaMapper qnaMapper;

    private Long qnaId;
    private Long userId;
    private String qnaTitle;
    private String qnaContent;
    private String qnaRegisterDateTime;
    private Boolean qnaIsPublic;
    private String doctorDepartmentType;

    @Test
    public void selectListTest() {
        QnaVO qnaVO = new QnaVO();
        qnaVO.setQnaId(1L);
        qnaVO.setUserId(1111L);
        qnaVO.setQnaTitle("test title");
        qnaVO.setQnaContent("test content");
        qnaVO.setQnaIsPublic(QuestionType.PUBLIC.isPublic());
        qnaVO.setDoctorDepartmentType(DepartmentType.MENTAL_HEALTH.getType());

//        IntStream.range(0, 10).forEach(i -> qnaMapper.insert(qnaVO));

        AssertionsForClassTypes.assertThat(qnaMapper.selectList(0).size()).isEqualTo(1);
    }

//    @Test
//    public void insertTest() {
//
//        QnaVO qnaVO = new QnaVO();
//        qnaVO.setQnaId(1L);
//        qnaVO.setQnaTitle("테스트 제목2");
//        qnaVO.setQnaContent("테스트 내용2");
//        qnaMapper.insert(qnaVO);
//    }

//    @Test
//    public void selectAllTest() {
//        assertThat(qnaMapper.selectList()).hasSize(2);
//    }

//    @Test
//    public void selectTest() {
//        qnaMapper.selectOne(2L).map(qnaDTO::getMemberName).ifPresent(log::info);
//    }

//    @Test
//    public void updateTest() {
//        qnaMapper.select(2L).ifPresent(qnaDTO -> {
//            qnaDTO.setqnaContent("수정된 내용");
//            qnaMapper.update(qnaDTO);
//        });
//    }

//    @Test
//    public void deleteTest() {
//        qnaMapper.delete(2L);
//        assertThat(qnaMapper.selectAll()).hasSize(1);
//    }
}
