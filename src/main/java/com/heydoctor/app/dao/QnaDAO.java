package com.heydoctor.app.dao;

import com.heydoctor.app.domain.dto.QnaDTO;
import com.heydoctor.app.domain.vo.QnaVO;
import com.heydoctor.app.mapper.QnaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class QnaDAO {
    private final QnaMapper qnaMapper;

    public List<QnaVO> findAll(int page) {
        return qnaMapper.selectList(page);
    }

    public Optional<QnaDTO> findById(Long qnaId) {
        return qnaMapper.selectOne(qnaId);
    }

    public void setQnaVO(QnaVO qnaVO) {
        qnaMapper.insert(qnaVO);
    }
}
