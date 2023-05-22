package com.heydoctor.app.dao;

import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.QuestionListDTO;
import com.heydoctor.app.domain.vo.QuestionVO;
import com.heydoctor.app.mapper.AdminMapper;
import com.heydoctor.app.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AdminDAO {
    private final AdminMapper adminMapper;

    public List<QuestionListDTO> findAll(Integer page) {
        return adminMapper.selectLists(page);
    }

    public Optional<QuestionDTO> findById(Long questionId) {
        return Optional.ofNullable(adminMapper.select(questionId));
    }

    public void delete(Long questionId) {
        adminMapper.delete(questionId);
    }

}
