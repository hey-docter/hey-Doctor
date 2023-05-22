package com.heydoctor.app.service.adminpage;

import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.domain.vo.QuestionVO;

import java.util.List;
import java.util.Optional;

public interface AdminpageService {
    public List<QuestionListDTO> getList(Integer page);

    public Optional<QuestionDTO> read(Long questionId);

    public void delete(Long questionId);
}
