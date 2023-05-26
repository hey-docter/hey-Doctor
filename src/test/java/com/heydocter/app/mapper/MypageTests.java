package com.heydocter.app.mapper;


import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.domain.enums.DepartmentType;
import com.heydoctor.app.domain.enums.QuestionType;
import com.heydoctor.app.domain.vo.QuestionVO;
import com.heydoctor.app.domain.vo.UserVO;
import com.heydoctor.app.mapper.MypageMapper;
import com.heydoctor.app.mapper.QuestionMapper;
import com.heydoctor.app.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class MypageTests {

    @Autowired
    private MypageMapper mypageMapper;

    //mypage 게시글 불러오기
    @Test
    public void selectListTest() {
        QuestionVO questionVO = new QuestionVO();
        questionVO.setQuestionContent("내용");
        questionVO.setQuestionIsPublic(QuestionType.PUBLIC.isPublic());
        questionVO.setQuestionTitle("타이틀");
        questionVO.setUserId(1L);
        questionVO.setDoctorDepartmentType(DepartmentType.MENTAL_HEALTH.name());


    }

}
