package com.heydocter.app.mapper;


import com.heydoctor.app.HeydocterApplication;
import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.domain.dto.Search;
import com.heydoctor.app.domain.enums.DepartmentType;
import com.heydoctor.app.domain.enums.QuestionType;
import com.heydoctor.app.domain.vo.QuestionVO;
import com.heydoctor.app.mapper.SearchMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(classes = HeydocterApplication.class)
@Slf4j
public class SearchMapperTests {
    @Autowired
    private SearchMapper searchMapper;

    @Test
    public void selectListTest() {
        QuestionDTO questionDTO = new QuestionDTO();
        questionDTO.setQuestionContent("test content");
        questionDTO.setQuestionIsPublic(QuestionType.PUBLIC.isPublic());
        questionDTO.setQuestionTitle("test title");
        questionDTO.setUserId(1L);

        //IntStream.range(0, 10).forEach(i -> questionMapper.insert(questionVO));

        searchMapper.selectAll(new Search("목이 아파요")).stream().map(QuestionDTO::toString).forEach(log::info);
    }


}
