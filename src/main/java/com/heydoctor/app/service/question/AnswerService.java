package com.heydoctor.app.service.question;

import com.heydoctor.app.domain.dto.AnswerDTO;
import com.heydoctor.app.domain.vo.AnswerVO;

import java.util.List;

public interface AnswerService {
    public void write(AnswerVO answerVO);
    public List<AnswerDTO> getAllAnswer(Long questionId);

}
