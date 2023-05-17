package com.heydoctor.heydoctor.domain.dao;

import com.heydoctor.heydoctor.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class QuestionDAO {
    private final QuestionMapper questionMapper;
}
