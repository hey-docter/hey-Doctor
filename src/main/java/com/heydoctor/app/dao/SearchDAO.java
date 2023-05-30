package com.heydoctor.app.dao;

import com.heydoctor.app.domain.dto.QuestionDTO;
import com.heydoctor.app.domain.dto.Search;
import com.heydoctor.app.domain.vo.BookReqeustVO;
import com.heydoctor.app.mapper.SearchMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SearchDAO {
    private final SearchMapper searchMapper;

    // 게시글 검색 & 목록
    public List<QuestionDTO> findAll(Search search){
        return searchMapper.selectAll(search);
    }

    public List<QuestionDTO> findQuestion() {return searchMapper.selectOne();}

    public List<BookReqeustVO> findBook(Search search) {return searchMapper.selectAllBook(search);}

    // 게시글 개수
    public int findCount(Search search) {
        return searchMapper.selectCount(search);
    }
}
