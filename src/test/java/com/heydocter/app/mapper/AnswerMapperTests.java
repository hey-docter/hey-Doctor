package com.heydocter.app.mapper;

import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.domain.enums.DepartmentType;
import com.heydoctor.app.domain.vo.AnswerVO;
import com.heydoctor.app.domain.vo.DoctorVO;
import com.heydoctor.app.domain.vo.HospitalVO;
import com.heydoctor.app.mapper.AnswerMapper;
import com.heydoctor.app.mapper.DoctorMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class AnswerMapperTests {

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private DoctorMapper doctorMapper;

    @Test
    public void insertTest() {
        AnswerVO answerVO = new AnswerVO();
        answerVO.setAnswerContent("test content1");
        answerVO.setAnswerIsAdopted(true);
        answerVO.setAnswerIsPublic(true);
        answerVO.setQuestionId(6L);
        answerVO.setAnswerTitle("test title1");
        answerVO.setAnswerLikeCount(3);
        answerVO.setDoctorDepartmentType(DepartmentType.ENT_CLINIC.getType());
        answerVO.setHospitalName("test hospital1");
        answerVO.setDoctorName("test doctor");
        answerVO.setUserId(1L);

        answerMapper.insert(answerVO);

        answerVO.setAnswerContent("test content1");
        answerVO.setAnswerIsAdopted(true);
        answerVO.setAnswerIsPublic(true);
        answerVO.setQuestionId(8L);
        answerVO.setAnswerTitle("test title1");
        answerVO.setAnswerLikeCount(3);
        answerVO.setDoctorDepartmentType(DepartmentType.ENT_CLINIC.getType());
        answerVO.setHospitalName("test hospital1");
        answerVO.setUserId(1L);

        answerMapper.insert(answerVO);

        answerVO.setAnswerContent("test content1");
        answerVO.setAnswerIsAdopted(true);
        answerVO.setAnswerIsPublic(true);
        answerVO.setQuestionId(9L);
        answerVO.setAnswerTitle("test title1");
        answerVO.setAnswerLikeCount(3);
        answerVO.setDoctorDepartmentType(DepartmentType.ENT_CLINIC.getType());
        answerVO.setHospitalName("test hospital1");
        answerVO.setUserId(1L);

        answerMapper.insert(answerVO);

    }

    @Test
    public void selectByQuestionIdsTest() {
        assertThat(answerMapper.selectByQuestionId(6L).size()).isEqualTo(2);
    }

    @Test
    public void selectByAdoptCountTest() {
        log.info(answerMapper.selectByAdoptCount().toString());
    }
}
