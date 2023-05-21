package com.heydoctor.app.service.adminpage;

import com.heydoctor.app.domain.dto.QnanDTO;
import com.heydoctor.app.domain.vo.QnaVO;

import java.util.List;
import java.util.Optional;

public interface AdminpageService {
    public List<QnaVO> getList(int page);

    public Optional<QnaDTO> read(Long qnaId);

    public void delete(qnaId);
}
