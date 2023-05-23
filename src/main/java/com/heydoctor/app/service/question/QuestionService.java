package com.heydoctor.app.service.question;

import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.domain.vo.QuestionVO;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    public List<QuestionListDTO> getList(Integer page);

    public Optional<QuestionDTO> read(Long questionId);

    public void write(QuestionVO questionVO);

    public Integer getBookmarkCount(Long questionId);

<<<<<<< HEAD
    public List<QuestionVO> getListReadCountDescAll();
=======

>>>>>>> 592f235a05d0d78903c2d773e230a1a18244c69e
}
