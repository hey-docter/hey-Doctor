package com.heydoctor.app.service.question;

import com.heydoctor.app.dao.AnswerDAO;
import com.heydoctor.app.domain.dto.AnswerDTO;
import com.heydoctor.app.domain.vo.AnswerVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Qualifier("answer") @Primary
public class AnswerServiceImpl implements AnswerService {
    private final AnswerDAO answerDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AnswerDTO write(AnswerVO answerVO) {
        answerDAO.insert(answerVO);
        Optional<AnswerDTO> checkAnswerDTO = answerDAO.select(answerVO.getAnswerId());

        return checkAnswerDTO.orElse(null);
    }

    @Override
    public List<AnswerDTO> getAllAnswer(Long questionId) {
        return answerDAO.getAllAnswers(questionId);
    }

    @Override
    public Optional<AnswerDTO> getAnswer(Long answerId) {
        return answerDAO.select(answerId);
    }

    @Override
    public List<AnswerVO> getListDoctorListAll() {
        return answerDAO.findByAdoptCount();
    }
}
