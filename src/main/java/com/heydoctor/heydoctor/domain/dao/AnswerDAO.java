package com.heydoctor.heydoctor.domain.dao;

import com.heydoctor.heydoctor.mapper.AnswerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AnswerDAO {
    private final AnswerMapper answerMapper;
}
