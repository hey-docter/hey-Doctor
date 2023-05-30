package com.heydocter.app.mapper;


import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.dto.Search;
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

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class QnaMapperTests {

    @Autowired
    private QnaMapper qnaMapper;

    @Test
    public void insertTest() {
        QnaVO qnaVO = new QnaVO();
        qnaVO.setUserId(1L);
        qnaVO.setQnaTitle("test title7");
        qnaVO.setQnaContent("test content7");
        qnaVO.setQnaIsPublic(QuestionType.PUBLIC.isPublic());
        qnaMapper.insert(qnaVO);
    }

    @Test
    public void selectListTest() {
        Pagination pagination = new Pagination();
        Search search = new Search();
        pagination.setPage(1);
//        AssertionsForClassTypes.assertThat(qnaMapper.selectList(pagination, search).size()).isEqualTo(2);
        for(QnaDTO qnaDTO: qnaMapper.selectList(pagination, search)){
            System.out.println(qnaDTO.toString());
        }
    }

    @Test
    public void selectOneTest() {
        qnaMapper.selectOne(19L).map(QnaDTO::toString).ifPresent(log::info);
    }

    @Test
    public void deleteTest() {
        qnaMapper.delete(43L);
//        assertThat(qnaMapper.selectList(0)).hasSize(2);
    }
}
