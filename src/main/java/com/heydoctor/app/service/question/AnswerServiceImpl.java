package com.heydoctor.app.service.question;

import com.heydoctor.app.dao.AnswerDAO;
import com.heydoctor.app.domain.dto.AnswerDTO;
import com.heydoctor.app.domain.vo.AnswerVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("answer") @Primary
public class AnswerServiceImpl implements AnswerService {
    private final AnswerDAO answerDAO;

    @Override
    public void write(AnswerVO answerVO) {
        answerDAO.insert(answerVO);
    }

    @Override
    public List<AnswerDTO> getAllAnswer(Long questionId) {
        return answerDAO.getAllAnswers(questionId);
    }

}
