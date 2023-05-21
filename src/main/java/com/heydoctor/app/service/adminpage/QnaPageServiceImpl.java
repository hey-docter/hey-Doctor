package com.heydoctor.app.service.adminpage;

import com.heydoctor.app.dao.QnaDAO;
import com.heydoctor.app.domain.dto.QnaDTO;
import com.heydoctor.app.domain.vo.QnaVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QnaPageServiceImpl implements QnaPageService{
    private final QnaDAO qnaDAO;

    @Override
    public void insert(QnaVO qnaVO) {

    }

    @Override
    public List<QnaDTO> getList(int page) {
        return qnaDAO.getAll(page);
    }

    @Override
    public Optional<QnaDTO> read(Long qnaId) {
        return qnaDAO.findById(qnaId);
    }

    @Override
    public void delete(int qnaId) {
        qnaDAO.deleteQna(qnaId);
    }
}
