package com.heydoctor.app.dao;

import com.heydoctor.app.domain.dto.Pagination;
import com.heydoctor.app.domain.dto.QnaDTO;
import com.heydoctor.app.domain.dto.Search;
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

    public void register(QnaVO qnaDTO){qnaMapper.insert(qnaDTO);}

    public List<QnaDTO> getAll(Pagination pagination, Search search) {
        return qnaMapper.selectList(pagination, search);
    }

    public Optional<QnaDTO> findById(Long qnaId) {
        return qnaMapper.selectOne(qnaId);
    }

    public void deleteQna(Long qnaId) {
        qnaMapper.delete(qnaId);
    }

    //    게시글 총 개수
    public int findCountOfPost(Search search){
        return qnaMapper.selectCountOfPost(search);
    }
}
