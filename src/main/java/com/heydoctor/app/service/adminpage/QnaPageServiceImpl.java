package com.heydoctor.app.service.adminpage;

import com.heydoctor.app.dao.QnaDAO;
import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.dto.QnaDTO;
import com.heydoctor.app.domain.dto.Search;
import com.heydoctor.app.domain.vo.QnaVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QnaPageServiceImpl implements QnaPageService{
    private final QnaDAO qnaDAO;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(QnaVO qnaVO) {
        qnaDAO.register(qnaVO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<QnaDTO> getList(Pagination pagination, Search search) {
        return qnaDAO.getAll(pagination, search);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<QnaDTO> read(Long qnaId) {
        return qnaDAO.findById(qnaId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteQna(Long qnaId) {
        qnaDAO.deleteQna(qnaId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int getTotal(Search search) {
        return qnaDAO.findCountOfPost(search);
    }
}
