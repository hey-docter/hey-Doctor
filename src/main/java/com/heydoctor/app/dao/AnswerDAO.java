package com.heydoctor.app.dao;

import com.heydoctor.app.domain.dto.AnswerDTO;
import com.heydoctor.app.domain.vo.AnswerVO;
import com.heydoctor.app.mapper.AnswerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AnswerDAO {
    private final AnswerMapper answerMapper;

    public List<AnswerDTO> getAllAnswers(Long questionId) {
        return answerMapper.selectByQuestionId(questionId);
    }

    public void insert(AnswerVO answerVO) {
        answerMapper.insert(answerVO);
    }
}
