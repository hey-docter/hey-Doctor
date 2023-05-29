package com.heydoctor.app.service.question;

import com.heydoctor.app.domain.dto.AnswerDTO;
import com.heydoctor.app.domain.vo.AnswerVO;

import java.util.List;
import java.util.Optional;

public interface AnswerService {
    public AnswerDTO write(AnswerVO answerVO);
    public List<AnswerDTO> getAllAnswer(Long questionId);

    Optional<AnswerDTO> getAnswer(Long answerId);

    public List<AnswerVO> getListDoctorListAll();
}
