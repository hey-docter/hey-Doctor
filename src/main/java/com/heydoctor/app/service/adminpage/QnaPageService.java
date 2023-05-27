package com.heydoctor.app.service.adminpage;

import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.dto.QnaDTO;
import com.heydoctor.app.domain.dto.Search;
import com.heydoctor.app.domain.vo.QnaVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface QnaPageService {
    public void register(QnaVO qnaVO);

    public List<QnaDTO> getList(Pagination pagination, Search search);

    public Optional<QnaDTO> read(Long qnaId);

    public void deleteQna(List<Long> qnaId);

    //    게시글 전체 개수 조회
    public int getTotal(Search search);
}
