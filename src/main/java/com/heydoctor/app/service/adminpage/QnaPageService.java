package com.heydoctor.app.service.adminpage;

import com.heydoctor.app.domain.dto.QnaDTO;
import com.heydoctor.app.domain.vo.QnaVO;

import java.util.List;
import java.util.Optional;

public interface QnaPageService {
    public void insert(QnaVO qnaVO);

    public List<QnaDTO> getList(int page);

    public Optional<QnaDTO> read(Long qnaId);

    public void delete(Long qnaId);
}
